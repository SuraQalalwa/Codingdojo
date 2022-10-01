
from django.shortcuts import render , HttpResponse , redirect 
from .models import Book , Author
from multiprocessing import context
from django.contrib import messages

# Create your views here.
def method(request):
    context={
        'allbooks':Book.objects.all()
    }
    return render(request,'index.html',context)

def method2(request):
    context={
        'allauthors':Author.objects.all()
    }
    return render(request,'code.html',context)

def showdataauthor(request):
    Author.objects.create(
        first_name=request.POST['first_name'],
        last_name= request.POST['last_name'],
        note= request.POST['note'],
    )
    return redirect  ('/authors')

def showdatabook(request):
    errors = Book.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect  ('/') 
    else:
        Book.objects.create(
        title=request.POST['title'],
        description=request.POST['description']
    )
    return redirect  ('/') 

def showbook(request,id):
    data= Book.objects.get(id=int(id)) 
    Authors = Author.objects.all()
    context={
        'book': data,
        'allauthors':Author.objects.all(),
        'allauthor_exclude':Author.objects.exclude(id__in=data.authors.all())
    }
    return render(request,'book.html', context)   

def authtobook(request,bookid):
    book1=Book.objects.get(id=int(bookid))
    auth1=Author.objects.get(id=request.POST['authtobook'])
    book1.authors.add(auth1)
    return redirect ('/books/'+str(bookid))

def showauthor(request,id):
    reference= Author.objects.get(id=int(id)) 
    Books = Book.objects.all()
    context={
        'author': reference,
        'allbooks': Book.objects.all(),
        'allbook_exclude':Book.objects.exclude(id__in=reference.book.all())
    }
    return render(request,'code.html', context) 

def booktoauth(request, authid):
    auth1=Author.objects.get(id=int(authid))
    book1=Book.objects.get(id=request.POST['booktoauth'])
    auth1.book.add(book1)
    return redirect ('/authors/'+str(authid))



