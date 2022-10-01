
from xml.etree.ElementInclude import include
from django.contrib import admin
from django.urls import path , include

urlpatterns = [
    path('/', include('gold_game_app.urls')),
]
