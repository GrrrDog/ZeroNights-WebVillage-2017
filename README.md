# ZeroNights-WebVillage-2017

Tasks are based on [the presentation](https://www.slideshare.net/GreenD0g/deserialization-vulnerabilities) from [ZeroNights 2017](https://2017.zeronights.org/)

Several simple webapps with deserialization vulnerabilities in Docker containers

1) Python. Pickle

    docker run -p 8080:80 greendog/wv_python

- https://www.cs.uic.edu/~s/musings/pickle/
- https://blog.nelhage.com/2011/03/exploiting-pickle/

2) Node.js. node-serialize

    docker run -p 8080:8080 greendog/wv_node

- https://opsecx.com/index.php/2017/02/08/exploiting-node-js-deserialization-bug-for-remote-code-execution/

3) Java. Native Binary deserialization

    docker run -p 8080:8090 greendog/wv_java

- https://github.com/frohoff/ysoserial
- https://github.com/federicodotta/Java-Deserialization-Scanner
- https://github.com/NetSPI/JavaSerialKiller
- https://github.com/GrrrDog/Java-Deserialization-Cheat-Sheet

4) Java. Jackson 

     docker run -p 8080:8090 greendog/wv_java

- https://adamcaudill.com/2017/10/04/exploiting-jackson-rce-cve-2017-7525/
- https://github.com/mbechler/marshalsec
