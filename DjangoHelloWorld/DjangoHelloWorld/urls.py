"""DjangoHelloWorld URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
# from django.conf.urls import url
# from django.contrib import admin

# urlpatterns = [
#     url(r'^admin/', admin.site.urls),
# ]
from django.conf.urls import url
from . import dbopretion
# from TestModel import views
from FirstApp import views

urlpatterns = [
    # url(r'^hello$', views.hello),
    url(r'^addusername$', dbopretion.addname),
    url(r'^addplace$', dbopretion.add_place_name),
    url(r'^updateplace$', dbopretion.update_place_name),
    url(r'^deleteplace$', dbopretion.delete_place_name),
    url(r'^showplace$', dbopretion.show_place_name),
    url(r'^form$', views.show_form),
]