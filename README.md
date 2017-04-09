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
  
  
## Code snippet with explanations

### Server
GreeterServiceImpl: 
@ServiceExporter - Marks the annotated class to be registered as the implementation bean as part of service definition of micro-service;

```java
@Service
@ServiceExporter
public class GreeterServiceImpl extends GreeterImplBase {
  ...
}
```

### Client

GreeterClientController:
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



