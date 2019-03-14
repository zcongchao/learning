from django.shortcuts import render, redirect
from django.http import HttpResponse


# Create your views here.

def home_page(request):
     
     if request.method == "POST":
          
         text = request.POST['item_text']

         if text == "汤元元":
             #重定向
             return redirect('/lists/the-only-list-in-the-world/')
             
         if text == "邹聪超":
             return redirect('/lists/the-next-list-in-the-world/')
     #items = '汤元元是头猪'
     return render(request, 'home.html')
     
def view_list( request ):
    items = '汤元元是头猪,好吃懒做'
    return render(request, 'home.html', {'items':items})
    
def new_list( request ):
    items = '邹聪超是天才，勤奋好学'
    return render(request, 'home.html', {'items':items})
     
    
    

