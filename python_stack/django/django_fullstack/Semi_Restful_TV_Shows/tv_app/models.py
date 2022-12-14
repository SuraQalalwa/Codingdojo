from platform import release
from django.db import models
from django.db.models import Model


class BlogManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 2:
            errors["title"] = "Show title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Show network should be at least 3 characters"
        if len(postData['description']) < 10:
            errors["description"] = "Show description should be at least 10 characters"    
        return errors

# class GeeksModel(Model):
#     title = models.CharField(
#                     max_length = 200,  
#                     unique = True
#                     ) 

class Server( models.Model ):
    title = models.GenericIPAddressField( blank = False, null = False, unique = True )



class Show(models.Model):
    title = models.CharField(max_length=255)
    network=models.CharField(max_length=255)
    releasedate =models.DateField(blank=True,null=True)
    description = models.TextField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BlogManager()
