from flask import Flask, request
import random
import pickle
import codecs

app = Flask(__name__)
 
class User(object):
    def __init__(self, name):
        self.id = random.randint(1,100000)
        self.name = name
    def __str__(self):
    	return "id:{} name:{}".format(self.id, self.name)

@app.route("/")
def index():
    name =  request.args.get('name', default = 'test')
    user = User(name)
    print(user)
    serUser = codecs.encode(pickle.dumps(user), "base64").decode()

    return "<a href='/?name=test'>set your name</a></br><a href='pydeser?sess=" + serUser + "'>look at yourself</a>"
 

@app.route("/pydeser")
def pydeser():
    strUser =  request.args.get('sess') 
    user = pickle.loads(codecs.decode(strUser.encode(), "base64"))

    return "Hello "+ str(user)
 

 
if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)