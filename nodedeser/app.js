var express = require('express');
var serialize = require('node-serialize');

var port = process.env.PORT || 8080;
var host = process.env.HOST || '0.0.0.0';

var app = express();

function randInt(){
	return  Math.floor(Math.random()*100000);
}

app.get('/', (req, res) => {
  var uname=req.query.name || "test";
  var user=	{id: randInt(), name: uname };
  var serUser = serialize.serialize(user);

  var b64u=Buffer(serUser).toString('base64');
  res.send("<a href='/?name=test'>set your name</a></br><a href='nodedeser?sess=" + b64u + "'>look at yourself</a>");
});

app.get('/nodedeser', (req, res) => {
  var strUser=new Buffer(req.query.sess, 'base64').toString('ascii');
  res.send(strUser);
  var user= serialize.unserialize(strUser);
  res.send("Hello id: " + user.id + " name: " +user.name);
});


app.listen(port, host);
console.log(`Running on http://${port}:${host}`);