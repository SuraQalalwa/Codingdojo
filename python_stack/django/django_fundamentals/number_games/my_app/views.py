from django.shortcuts import render
import random 
# Create your views here.
def method1(request):
    compnumber=random.randint(1, 100) 
    request.session['random']= compnumber
    print (compnumber)
    return render (request, 'index.html')


def method2(request):
    user = int(request.POST['usernum'])
    if user > request.session['random']:
        massg='it too high'
    elif user < request.session['random']:
        massg='it too low'
    else  :   
        massg='correct'
    context={
        'massage': massg
    }
    return render(request, 'index.html',context )