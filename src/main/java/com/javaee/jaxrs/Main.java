package com.javaee.jaxrs;

import java.io.IOException;
import java.net.URI;

import org.apache.log4j.BasicConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	public static final String BASE_URI = "http://localhost:8080/";
	
	public static HttpServer startServer() {
		final ResourceConfig config = new ResourceConfig().packages("com.javaee.jaxrs.controllers");
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
	}
	
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		final HttpServer server = startServer();
		System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl\nHit enter to stop...", BASE_URI));
		System.in.read();
		server.shutdown();
	}
}
