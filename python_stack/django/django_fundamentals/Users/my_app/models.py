from django.db import models

# Create your models here.
class Users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.TextField(max_length=255)
    email_address = models.TextField(max_length=255)
    age = models.IntegerField() 
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


# Users.objects.create(first_name='Sura',last_name='Qalalwa',email_address='sura@gmail.com',age='26')