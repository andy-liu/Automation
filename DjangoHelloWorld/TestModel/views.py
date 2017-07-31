from django.shortcuts import render

# Create your views here.


def hello(request):
    context = {}
    context['title'] = '标题'
    context['description'] = 'This is your first Django project!'
    context['content'] = 'Using face detection technology, Hover Camera Passport can track your face or\
     body and accompany your journey. '
    return render(request, 'hello.html', context)
