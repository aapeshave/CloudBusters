import time;
import requests;



loginPayload = {'username': 'pooja', 'password': 'admin'}
loginRequest = requests.post('http://blogit.us-east-1.elasticbeanstalk.com/login', params=loginPayload)
	#print loginRequest.content;
assert(loginRequest.status_code == 200), 'not 200';

createBlogPayload = {'blogName': 'sample', 'blogDescription': 'sample description'};
createBlogRequest = requests.post('http://blogit.us-east-1.elasticbeanstalk.com/blog', params=createBlogPayload)
print createBlogRequest.content;
assert(createBlogRequest.status_code == 200), 'not 200';

logoutRequest = requests.get('http://blogit.us-east-1.elasticbeanstalk.com/logout');
	#print logoutRequest.content;
assert(logoutRequest.status_code == 200), 'not 200';

