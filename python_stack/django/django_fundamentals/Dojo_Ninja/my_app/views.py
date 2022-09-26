from socket import NI_NAMEREQD
from django.shortcuts import render , HttpResponse , redirect
from .models import Dojos , Ninjas
from multiprocessing import context

# Create your views here.

def method(request):
    context={
        'allninjas':Ninjas.objects.all(),
        'alldojos':Dojos.objects.all()
    }
    return render(request,'index.html',context)

def showdataninja(request):
    print(request.POST['dojo'])
    Ninjas.objects.create(
        first_name=request.POST['first_name'],
        last_name= request.POST['last_name'],
        dojo = Dojos.objects.get(id=request.POST['dojo'])
    )

    return redirect  ('/')


def showdatadojo(request):
    Dojos.objects.create(
            name=request.POST['name'],
            city= request.POST['city'],
            state= request.POST['state']
    )
    return redirect  ('/')