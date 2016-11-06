## etherjar.starter

This is a personal project for trying out etherjar:

```
git clone https://github.com/rguiu/etherjar.starter
./gradlew run
```

TODO: Write instructions... 

Commands 
```
 curl -w "\n" -X GET http://localhost:8080/block/2000000
 curl -w "\n" -X GET http://localhost:8080/block/last
 curl -w "\n" -X GET http://localhost:8080/hashrate/submit/0x0000000000000000000000000000000000000000000000000000000000500000
 curl -w "\n" -X GET http://localhost:8080/work/submit/0x0000000000000000
 curl -w "\n" -X GET http://localhost:8080/work/fetch
 curl -w "\n" -X GET http://localhost:8080/coinbase
 curl -w "\n" -X GET http://localhost:8080/hashrate
 curl -w "\n" -X GET http://localhost:8080/isMining
 curl -w "\n" -X GET http://localhost:8080/gasPrice
 curl -w "\n" -X GET http://localhost:8080/accounts
 curl -w "\n" -X GET http://localhost:8080/compilers
 
```