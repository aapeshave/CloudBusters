import time;
import requests;


def doSendRequests():
	payload = {'username': 'pooja', 'password': 'admin'}
	loginRequest = requests.post('http://blogit.us-east-1.elasticbeanstalk.com/login', params=payload)
	print loginRequest.content;
	logoutRequest = requests.get('http://blogit.us-east-1.elasticbeanstalk.com/logout')
	print logoutRequest.content;

while True:
    doSendRequests()