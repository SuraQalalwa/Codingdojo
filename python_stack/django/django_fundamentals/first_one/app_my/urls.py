from django.urls import path
from . import views
urlpatterns = [
    # path('',views.method1),
    # path('hello/<int:id>',views.method2),
    # path('file',views.method3),
    path('show',views.rform),
    path('users',views.users)
]
