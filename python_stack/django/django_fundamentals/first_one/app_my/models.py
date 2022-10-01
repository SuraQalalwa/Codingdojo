from django.db import models

# Create your models here.
class User(models.Model):
    username = models.CharField(max_length=45)
    location = models.TextField(max_length=45)
    language = models.DateField(max_length=45)
    message = models.DateField(max_length=45)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

