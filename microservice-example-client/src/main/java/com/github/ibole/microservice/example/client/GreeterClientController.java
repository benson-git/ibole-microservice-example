/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.ibole.microservice.example.client;

import com.github.ibole.microservice.config.annotation.Reference;
import com.github.ibole.microservice.example.common.GreeterGrpc.GreeterBlockingStub;
import com.github.ibole.microservice.example.common.HelloWorldProto.HelloReply;
import com.github.ibole.microservice.example.common.HelloWorldProto.HelloRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*********************************************************************************************.
 * 
 * 
 * <p>Copyright 2016, iBole Inc. All rights reserved.
 * 
 * <p></p>
 *********************************************************************************************/

  
/**
 * @author bwang
 *
 */
@Controller
@Component("greeterAction")
public class GreeterClientController{

  @Reference(timeout = 3000, preferredZone="myzone", usedTls=true)
  private GreeterBlockingStub blockingStub;

  
  @RequestMapping("/greet")
  @ResponseBody
  public String greet(HttpServletRequest req, HttpServletResponse res){
    HelloRequest request = HelloRequest.newBuilder().setName("world!").build();
    HelloReply response = blockingStub.sayHello(request);
    return response.getMessage();
  }
}
