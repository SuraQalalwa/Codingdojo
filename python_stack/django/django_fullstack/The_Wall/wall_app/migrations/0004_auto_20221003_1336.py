# Generated by Django 2.2.4 on 2022-10-03 10:36

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('wall_app', '0003_auto_20221003_1335'),
    ]

    operations = [
        migrations.AlterField(
            model_name='comment',
            name='message',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='comments', to='wall_app.Message'),
        ),
        migrations.AlterField(
            model_name='comment',
            name='user',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='comments', to='wall_app.User'),
        ),
        migrations.AlterField(
            model_name='message',
            name='user',
            field=models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='messages', to='wall_app.User'),
        ),
    ]
