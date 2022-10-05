from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

urlpatterns=[
    path('',views.index),
    path('register',views.register),
    path('book',views.book),
    path('login',views.login),
    path('logout',views.logout),
    path('create_book',views.create_book),
    path('favorite/<int:bookid>',views.favorite),
    path('books/<int:bookid>',views.showbook),
    path('unfavorite/<int:bookid>',views.unfavorite),
    path('edit',views.edit),
    path('delete',views.delete),
    
    
    
]
