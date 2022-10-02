from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

urlpatterns=[
    path('',views.index),
    path('register',views.register),
    path('home',views.home),
    path('login',views.login),
]
