package com.cosmo.ws.binary.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface FileTransferer {

	@WebMethod
	public void upload(String fileName, byte[] imageBytes);
	
	@WebMethod
	public byte[] download(String fileName);
	
}
