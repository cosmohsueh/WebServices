package com.cosmo.webservices.server;

import javax.xml.ws.Endpoint;

public class WebServiceServer {

	public static void main(String[] args) {
		String buildURL = "http://localhost:9898/md5WebService";
		MD5WebService webService = new MD5WebService();
		Endpoint.publish(buildURL, webService);
		System.out.println("Server started at: " + buildURL);
	}

}
