from django.db import models
import re
class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "Show title should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Show network should be at least 2 characters"
        if len(postData['password']) < 8:
            errors["password"] = "Password show description should be at least 8 characters" 
        if postData['password'] != postData['cpassword']:
            errors["password"] = "cpassword should match confirm password"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')   
        if not EMAIL_REGEX.match(postData['email']):           
            errors['email'] = "Invalid email address!"
        return errors    

# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    email = models.EmailField(max_length=45)
    password=models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

class Message(models.Model):
    message = models.TextField(max_length=255)
    user = models.ForeignKey(User,related_name="message", on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)    

class Comment(models.Model):
    comment = models.TextField(max_length=255)
    user = models.ForeignKey(User,related_name="comment_user", on_delete = models.CASCADE , null=True)
    message = models.ForeignKey(Message,related_name="comment_message", on_delete = models.CASCADE , null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True) 
