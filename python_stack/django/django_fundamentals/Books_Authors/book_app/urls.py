from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

# Create your views here.

urlpatterns = [
    path('', views.method),
    path('authors', views.method2),
    path('showauthor', views.showdataauthor),
    path('showbook', views.showdatabook),
    path('books/<int:id>', views.showbook),
    path('authors/<int:id>', views.showauthor),
    path('authtobook/<int:bookid>', views.authtobook),
    path('booktoauth/<int:authid>', views.booktoauth),
    
]

