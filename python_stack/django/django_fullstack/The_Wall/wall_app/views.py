import this
import bcrypt
from django.shortcuts import render , redirect
from multiprocessing import context
from django.shortcuts import render , HttpResponse , redirect 
from .models import User , Message, Comment
from multiprocessing import context
from django.contrib import messages

############# Login & Registration App.###########################3
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
    return redirect('/')

def login(request):
    user = User.objects.filter(email=request.POST['email']) 
    if user: 
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            messages.success(request,"Login successful")
            return redirect('/wall')
        messages.success(request,"Invaild credentials")  
        return redirect("/")  
    return redirect("/")

################### Wall App.###############################
def wall(request):
    context={
        'allmessages':reversed(Message.objects.all()),
        'allcomment':Comment.objects.all()
    }
    return render(request, 'index.html',context)

def addpost(request):
    if request.method == 'POST':
        this_user = User.objects.get(id=request.session['userid'])
        message = request.POST['message']
        new_post=Message.objects.create(user=this_user,message = message)
        new_post.save()
    return redirect('/wall')

def addcomment(request,message_id):
    # print("hiiiiiiiiiiiiiiiiiiiiii")
    if request.method == 'POST':
        this_user = User.objects.get(id=request.session['userid'])
        this_message = Message.objects.get(id=int(message_id))
        comment= request.POST['comment']
        new_comment=Comment.objects.create(comment=comment,user=this_user,message = this_message)
        new_comment.save()
    return redirect('/wall')    


def logoff(request):
    return redirect("/")







