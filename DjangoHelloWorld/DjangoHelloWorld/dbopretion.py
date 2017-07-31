# -*- coding: utf-8 -*-

from django.http import HttpResponse

from TestModel.models import username
from FirstApp.models import placename


# 数据库操作
def addname(request):
    name = username(name='learndjango')
    name.save()
    return HttpResponse("<p>添加成功！</p>")


def add_place_name(request):
    place_name_list = ['beijing', 'shanghai', 'tianjin', 'shenzhen', 'chongqing']
    for each in place_name_list:
        name = placename(name=each)
        name.save()
    return HttpResponse("<p>添加成功！</p>")


def update_place_name(request):
    data = placename.objects.get(id=1)
    data.name = 'lasha'
    data.save()
    return HttpResponse("<p>修改成功</p>")


def delete_place_name(request):
    data = placename.objects.get(id=1)
    data.delete()
    return HttpResponse("<p>删除成功</p>")

def show_place_name(request):
    list = placename.objects.all()
    first_place = placename.objects.filter(id=1)
    return HttpResponse(first_place)