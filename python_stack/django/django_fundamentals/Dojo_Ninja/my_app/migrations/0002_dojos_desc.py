# Generated by Django 2.2.4 on 2022-09-24 21:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('my_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='dojos',
            name='desc',
            field=models.TextField(null=True),
        ),
    ]
