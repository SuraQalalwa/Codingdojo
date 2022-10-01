from django.shortcuts import render , redirect
from .models import Users

# Create your views here.
def index(request):
    context={
        'allusers':Users.objects.all()
    }
    return render(request,'index.html',context)

def showdata(request):
    first_name=request.POST['first_name']
    last_name= request.POST['last_name']
    email_address= request.POST['email']
    age= int(request.POST['age'])
    Users.objects.create(first_name=first_name,last_name=last_name,email_address=email_address,age=age)

    return redirect  ('/')

    