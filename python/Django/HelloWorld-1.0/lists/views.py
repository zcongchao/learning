from django.shortcuts import render,redirect

def home_page(request):
    if request.method=="POST":
        text=request.POST['item_text']
        if text=="邹聪超":
            return redirect('/lists/the-only-list-in-the-world/')
    return render (request,'home.html')
def  view_list(request):
    items='邹聪超是傻子，只知道吃饭睡觉'
    return render(request,'home.html ',{'items':items})