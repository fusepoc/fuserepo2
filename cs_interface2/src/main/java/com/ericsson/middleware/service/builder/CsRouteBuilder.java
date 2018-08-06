package com.ericsson.middleware.service.builder;

import org.apache.camel.builder.RouteBuilder;

import com.ericsson.middleware.service.cs_interface2.incident.ReportIncidentProcessor;

public class CsRouteBuilder extends RouteBuilder {
	
	private ReportIncidentProcessor processor;
	
	
	@Override
	public void configure() throws Exception {

		from("cxf:bean:reportEndpoint").process(processor);
		
		//from("direct:reportIncident").process(processor);
	}


	public ReportIncidentProcessor getProcessor() {
		return processor;
	}


	public void setProcessor(ReportIncidentProcessor processor) {
		this.processor = processor;
	}
	
	

}
