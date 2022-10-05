from winreg import REG_QWORD
import bcrypt
from django.shortcuts import render, redirect
from django.contrib import messages
from .models import User , Book

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
    return redirect('/')

def login(request):
    user = User.objects.filter(email=request.POST['email']) 
    if user: 
        logged_user = user[0]
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            request.session['first_name']= logged_user.first_name
            messages.success(request,"Login successful")
            return redirect('/book')
        messages.success(request,"Invaild credentials")  # it's prefferd to put this message here to be not sure which is the error exactly
        return redirect("/")  
    return redirect("/")

def logout(request):
    # request.session.flush()
    del request.session['userid']
    del request.session['first_name']
    return redirect('/')

# FAV_BOOK App. ###########################
# RENDERING ALL BOOKS 
def book(request): 
    context={
        'allbooks':Book.objects.all(),
        'alldatauser':User.objects.get(id=request.session['userid']),
    }
    return render(request,'book.html',context)

# CREATE NEW BOOK
def create_book(request):
    user = User.objects.get(id=request.session['userid'])
    if request.method == 'POST':
        title = request.POST['title']
        description = request.POST['description']
        uploaded_by = User.objects.get(id=request.session['userid'])
        new_book = Book.objects.create(title=title,description=description,user=uploaded_by)
        user.liked_books.add(new_book)
    return redirect("/book")

# SHOW ALL BOOK DATA
def showbook(request,bookid):
    context={
        'alldatauser':User.objects.get(id=request.session['userid']),
        'alldatabook':Book.objects.get(id=bookid),
        # 'allfav': Book.objects.first().users_who_liked.all()
    }
    return render (request,'bookdata.html',context)

# ADD BOOK TO FAVORITE
def favorite(request,bookid):
    print("HIIIIIIIIIIIIIIIIIi")
    user= User.objects.get(id=request.session['userid'])
    book = Book.objects.get(id=bookid)
    user.liked_books.add(book)
    print(book.users_who_liked)
    return redirect('/books/'+str(bookid))

# REMOVE BOOK FROM FAVORITE
def unfavorite(request,bookid):
    user= User.objects.get(id=request.session['userid'])
    book = Book.objects.get(id=bookid)
    book.users_who_liked.remove(user)
    book.save()
    return redirect('/books/'+str(bookid))

# EDIT BOOK DESCRIPTION
def edit(request):
    bookid = request.POST['bookid']
    edit=Book.objects.get(id=bookid)
    edit.description= request.POST['desc1']
    edit.title= request.POST['title1']
    edit.save()
    messages.success(request,"Update Complete!")
    return redirect('/books/'+str(bookid))

# DELETE BOOK 
def delete(request):
    bookid = request.POST['bookid']
    this_book = Book.objects.get(id=bookid) 
    this_book.delete()   
    return redirect('/book')

