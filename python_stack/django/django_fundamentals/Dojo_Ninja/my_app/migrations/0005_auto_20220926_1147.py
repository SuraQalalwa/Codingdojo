# Generated by Django 2.2.4 on 2022-09-26 08:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('my_app', '0004_dojos_desc'),
    ]

    operations = [
        migrations.AlterField(
            model_name='dojos',
            name='desc',
            field=models.CharField(default='old dojo', max_length=255),
        ),
    ]