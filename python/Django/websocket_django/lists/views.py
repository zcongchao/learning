from dwebsocket import require_websocket
from django.shortcuts import render


@require_websocket
def echo_once(request):
    message = request.websocket.wait()
    print(message)
    message_send = 'hello'
    request.websocket.send(message_send)
	
def index(request):
    return render(request, 'home.html')