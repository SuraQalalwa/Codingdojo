from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

# Create your views here.

urlpatterns = [
    path('', views.method),
    path('show1', views.showdatadojo),
    path('show2', views.showdataninja),
    
]

