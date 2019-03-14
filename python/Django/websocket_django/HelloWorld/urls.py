from django.conf.urls import url
from lists import views as v


urlpatterns = [

    url(r'^$', v.index),
    url(r'^echo_once', v.echo_once),
]

