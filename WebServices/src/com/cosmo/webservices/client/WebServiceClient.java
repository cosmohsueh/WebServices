package com.cosmo.webservices.client;


public class WebServiceClient {

	public static void main(String[] args) {
		MD5WebServiceService service = new MD5WebServiceService();
		MD5WebService md5WebService = service.getMD5WebServicePort();
		String hash = md5WebService.hashString("aaa");
		System.out.println("MD5 hash string: " + hash);
	}

}
