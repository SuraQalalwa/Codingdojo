from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

urlpatterns=[
    path('',views.index),
    path('register',views.register),
    path('login',views.login),
    path('addpost',views.addpost),
    path('addcomment/<int:message_id>',views.addcomment),
    path('wall',views.wall),
    path('logoff',views.logoff),

    
    

]
