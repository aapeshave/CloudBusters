import requests;
import sched, time;

r = requests.get("http://blogit.us-east-1.elasticbeanstalk.com");
print r.content;

s = sched.scheduler(time.time, time.sleep);
def do_something(sc): 
    print "Doing stuff..."
    # do your stuff
    s.enter(60, 1, do_something, (sc,))

s.enter(60, 1, do_something, (s,));
s.run();