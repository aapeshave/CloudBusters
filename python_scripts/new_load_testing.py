import time
import requests;


def executeSomething():
    #code here
	r = requests.get("http://blogit.us-east-1.elasticbeanstalk.com");
	p = requests.get("http://blogit.us-east-1.elasticbeanstalk.com");
	print r.content;
	print p.content;
	r.raw.read()
	assert(r.status_code == 200), 'not 200'
	assert(p.status_code == 200), 'not 200'
#	time.sleep(1)

while True:
    executeSomething()