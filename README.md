# ibole-microservice-example
An example of applying ibole-microservice library.

---

## Overview

- Service Provider

  microservice-example-server

- Service Consumer

  microservice-example-client

- Common stuffing(Stub, Request, Response...) shares for server and client side

  microservice-example-common
 
 
## Project Dependency
  
  ![Project dependency](https://github.com/benson-git/wiki-docs/blob/master/images/ibole-microservice-example.jpg)
  
  
## Architecture
  
  ![Architecture](https://github.com/benson-git/wiki-docs/blob/master/images/ibole-microservice-example%20architecture.jpg)
  
  
## Code Snippet with Explanations

### Server
[GreeterServiceImpl](https://github.com/benson-git/ibole-microservice-example/blob/master/microservice-example-server/src/main/java/com/github/ibole/microservice/example/service/GreeterServiceImpl.java): 

@ServiceExporter - Marks the annotated class to be registered as the implementation bean as part of service definition of micro-service.

```java
@Service
@ServiceExporter
public class GreeterServiceImpl extends GreeterImplBase {
  ...
}
```

### Client

[GreeterClientController](https://github.com/benson-git/ibole-microservice-example/blob/master/microservice-example-client/src/main/java/com/github/ibole/microservice/example/client/GreeterClientController.java): 

@Reference - Discover the expected service from registry center and return instantiated client stub with the specific custom options.

```java
@Controller
public class GreeterClientController{

  @Reference(timeout = 3000, preferredZone="myzone", usedTls=true)
  private GreeterBlockingStub blockingStub;
    ...  
  }
}
```

## Run the Example

* Prerequisite

  Java version: 1.8+

  Maven: 3.3.9 ([Install and configure](https://maven.apache.org/install.html))

* Generate server/client stub for IDL 'helloworld.proto'

```
    cd ~/microservice-example-common  
    mvn compile  
```

* Run server application

```
    cd ~/microservice-example-server  
    mvn clean package
    java -jar target/microservice-example-server-1.0.1.jar  
```

* Run client web application

```
    cd ~/microservice-example-client  
    mvn jetty:run
```

Open the URL to run the greet example: http://localhost:8080/microservice-example-client/greet




