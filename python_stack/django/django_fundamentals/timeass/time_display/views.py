from django.shortcuts import render, HttpResponse
from time import gmtime, strftime
    
def root(request):
    context = {
        "time": strftime("%b %d, %Y", gmtime()),
        "time2": strftime("%H:%M %p", gmtime())
        
    }
    return render(request,'index.html', context)

