from django.db import models

# Create your models here.


class placename(models.Model):
    name = models.CharField(max_length=20)