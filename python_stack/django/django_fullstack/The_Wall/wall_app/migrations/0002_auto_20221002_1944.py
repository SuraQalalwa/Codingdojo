# Generated by Django 2.2.4 on 2022-10-02 16:44

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('wall_app', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='comment',
            name='message',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='comment_message', to='wall_app.User'),
        ),
        migrations.AlterField(
            model_name='comment',
            name='user',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='comment_user', to='wall_app.User'),
        ),
    ]
