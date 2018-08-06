/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ericsson.middleware.service.cs_interface2.incident;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.xmlrpc.client.XmlRpcClient;
/*import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;*/
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

/**
 * Processor for processing the report incident.
 */
public class ReportIncidentProcessor implements Processor {
	
	@Override
    public void process(Exchange exchange) throws Exception {
        // get the id of the input
		/*Message message = exchange.getIn();
		//if(message instanceof CxfM)
		
		Object obj = message.getBody();
		obj.getClass();
    	
        String id = exchange.getIn().getBody(InputReportIncident.class).getIncidentId();

        // set reply including the id
        OutputReportIncident output = new OutputReportIncident();
        output.setCode("OK;====;;" + id);
        exchange.getOut().setBody(output);*/
		
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		
		/*config.setServerURL(new URL("http://10.61.38.108:10000/Air"));
		config.setBasicUserName("user");
		config.setBasicPassword("user");
		config.setUserAgent("Air Server/5.0/1.0");*/
		
		config.setServerURL(new URL("http://localhost:8111"));
				
		XmlRpcClient client = new XmlRpcClient();
        
        client.setConfig(config);
        Vector params = new Vector();
        //params.addElement(obj);
        //params.addElement(new Integer(10));
        //params.addElement(new Integer(50));
        
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        
        params.addElement(map);
        Object result = client.execute("sample.getBalanceAndDate", params);
        
        Message message = exchange.getIn();
		//if(message instanceof CxfM)
		
		//Object obj = message.getBody();
		//obj.getClass();
    	
        String id = exchange.getIn().getBody(InputReportIncident.class).getIncidentId();

        // set reply including the id
        OutputReportIncident output = new OutputReportIncident();
        output.setCode("OK;====;;" + ((Integer) result).intValue());
        exchange.getOut().setBody(output);
    }

}
