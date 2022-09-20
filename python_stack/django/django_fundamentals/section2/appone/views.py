# from contextlib import redirect_stderr
# from multiprocessing import context
# from urllib import request
from django.shortcuts import render, HttpResponse

# Create your views here.
def method1(request):
    return HttpResponse('hELLO wORLD')

def method2(request, id):
    return HttpResponse('Hello '+ str(id))

def method3(request):
    context = {
        'var1':'Amin',
        'var2': 4,
        'var3': [1,2,3,4,5]
    }
    return render(request,"index.html",context)    
############################################################

def rform(request):
    return render(request, 'form.html')

def users(request):
    context={
        'username':request.POST['username'],
        'location': request.POST['location'],
        'language': request.POST['language'],
        'message': request.POST['message'],
    }

    return render(request, 'data.html', context)