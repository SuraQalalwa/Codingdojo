# Generated by Django 2.2.4 on 2022-09-28 08:50

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tv_app', '0002_auto_20220928_1147'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='releasedate',
            field=models.DateField(null=True),
        ),
    ]