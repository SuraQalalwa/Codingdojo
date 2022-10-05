from platform import release
from unittest.util import _MAX_LENGTH
from django.db import models
from django.db.models import Model
import re

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "Show first_name should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Show last_name should be at least 2 characters"
        if len(postData['email']) < 5:
            errors["email"] = "Show email should be at least 5 characters" 
        if len(postData['description']) < 5:
            errors["description"] = "Show description should be at least 5 characters"        
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters" 
        if postData['password'] != postData['cpassword']:
            errors["password"] = "cpassword should match confirm password"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')   
        if not EMAIL_REGEX.match(postData['email']):           
            errors['email'] = "Invalid email address!"
        return errors    

class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name=models.CharField(max_length=45)
    email =models.EmailField(max_length=45)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()
    # liked_books = a list of books a given user likes
    # books_uploaded = a list of books uploaded by a given user

class Book(models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField(max_length=255)
    user = models.ForeignKey(User,related_name="books_uploaded", on_delete = models.CASCADE)
    users_who_liked = models.ManyToManyField(User, related_name="liked_books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()
    # uploaded_by = user who uploaded a given book
    # users_who_like = a list of users who like a given book