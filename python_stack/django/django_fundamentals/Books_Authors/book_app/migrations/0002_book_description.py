# Generated by Django 2.2.4 on 2022-09-26 10:58

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('book_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='book',
            name='description',
            field=models.TextField(null=True),
        ),
    ]