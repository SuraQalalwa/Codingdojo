# Generated by Django 2.2.4 on 2022-09-23 17:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('my_app', '0003_auto_20220922_1344'),
    ]

    operations = [
        migrations.AlterField(
            model_name='users',
            name='first_name',
            field=models.TextField(max_length=255),
        ),
    ]
