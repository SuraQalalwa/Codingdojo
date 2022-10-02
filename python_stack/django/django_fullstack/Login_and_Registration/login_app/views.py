import bcrypt
from django.shortcuts import render, redirect
from django.contrib import messages
from .models import User

# Login & Registration App.
def index(request):
    return render(request,'login.html')

def register(request):
    errors = User.objects.basic_validator(request.POST)
    users= User.objects.all()
    for user in users:
        if user.email == request.POST['email']:
            errors['email']="This email already exist"
    if len(errors)>0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:    
        password=request.POST['password']
        pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
        print(pw_hash)
        User.objects.create(
        first_name= request.POST['first_name'],
        last_name= request.POST['last_name'],
        email= request.POST['email'],
        password= pw_hash
    )
        request.session['first_name']=User.objects.last().first_name
    return redirect('/home')

def home(request): #allbooks
    return render(request,'home.html')

def login(request):
    user = User.objects.filter(email=request.POST['email']) 
    if user: 
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            messages.success(request,"Login successful")
            return redirect('/home')
        messages.success(request,"Invaild credentials")  # it's prefferd to put this message here to be not sure which is the error exactly
        return redirect("/")  
    return redirect("/")