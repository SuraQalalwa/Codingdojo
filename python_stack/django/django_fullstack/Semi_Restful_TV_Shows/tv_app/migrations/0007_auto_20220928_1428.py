# Generated by Django 2.2.4 on 2022-09-28 11:28

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('tv_app', '0006_server'),
    ]

    operations = [
        migrations.DeleteModel(
            name='GeeksModel',
        ),
        migrations.DeleteModel(
            name='Server',
        ),
    ]
