from django.urls import path
from . import views

urlpatterns = [
    path('',views.method1),
    path('guess',views.method2),
]
