from multiprocessing import context
from platform import release
from turtle import title
from django.shortcuts import render , redirect
from .models import Show
from django.contrib import messages
#########TV SHOW APP ##########

#Present all TV shows
def allshow(request):
    context={
        'allshow':Show.objects.all()
    }
    return render(request,'allshow.html',context)

#Create New TV Show
def create(request):
    context={
        'allshows':Show.objects.all()
    }
    return render(request,'create.html',context)

#Create New TV Show from main page
def add_new_show(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect  ('/shows/new') 
    else:
        Show.objects.create(
            title=request.POST['title'],
            network= request.POST['network'],
            releasedate=request.POST['releasedate'],
            description= request.POST['description']
        )
    return redirect  ('/shows')


#Go Back to the main page
def go_back():
    return redirect  ('/shows')

def go_to_show(request,id):
    sho= Show.objects.get(id=int(id))
    context={
        'sho':sho
    }
    return render (request,'readone.html',context)    

#Introduce TV Show with specific ID
def introduce(request,id):
    context ={
        'showdata':Show.objects.get(id=int(id))
    }
    return render(request,'readone.html',context)

#Edit TV Show
def editme(request,id):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect  ('/shows/'+str(id)+'/edit') 
    else:
        edit = Show.objects.get(id=int(id))
        edit.title=request.POST['title']
        edit.network= request.POST['network']
        edit.releasedate=request.POST['releasedate']
        edit.description= request.POST['description']
        edit.save()
        return redirect('/shows/'+str(id))

#Go to Edit TV Show
def edit(request,id):
    edit = Show.objects.get(id=int(id))
    context={
        'edit': edit
    }
    return render(request,'edit.html', context)

# Delete all TV Show data from main page 
def delete(request,id):
    print('hi')
    delete_show=Show.objects.get(id=id)
    delete_show.delete()
    return redirect ('/shows')