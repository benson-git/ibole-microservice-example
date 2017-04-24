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

package com.github.ibole.microservice.example.bootstrap;

import com.github.ibole.microservice.remoting.curator.EmbedZkServer;
import com.github.ibole.microservice.rpc.server.ServerBootstrap;

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
public class App {
  private final static int SERVICE_PORT = 8443;
  private final static int ZK_PORT = 2181;
  /**
   * @param args the parameter to pass in
   * @throws Exception if exception happen
   */
  public static void main(String[] args) throws Exception {
    String[] args1 = new String[] {"--hostname=localhost", "--port="+SERVICE_PORT, "--reg_servers=localhost:"+ZK_PORT, "--use_tls=true"};
    //init and start a embed zk server for testing purpose
    //new EmbedZkServer().boot(ZK_PORT);
    //init and start micorservices server.
    ServerBootstrap.main(args1);

  }

}
