from django.shortcuts import render 
from .import models
from django.urls import path     
from . import views

# Create your views here.

urlpatterns = [
    path('shows/new', views.create),
    path('shows/create', views.add_new_show),
    path('shows', views.allshow),
    path('shows/<int:id>', views.introduce),
    path('shows/<int:id>/edit', views.edit),
    path('shows/<int:id>/editme', views.editme),
    path('shows/<int:id>/delete', views.delete),

    
]
