package com.cosmo.ws.binary.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WebServiceClient {

	public static void main(String[] args) {
		FileTransfererImplService client = new FileTransfererImplService();
		FileTransfererImpl server = client.getFileTransfererImplPort();
		
		String fileName = "Desert.jpg";
		String filePath = "E:/client/" + fileName;
		File file = new File(filePath);
		
		try{
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] imageBytes = new byte[(int) file.length()];
			bis.read(imageBytes);
			server.upload(file.getName(), imageBytes);
			fis.close();
			System.out.println("File uploaded: " + filePath);
		}catch (IOException e){
			e.printStackTrace();
		}
		
		fileName = "tresed.jpg";
		filePath = "E:/client/" + fileName;
		byte[] filebytes = server.download(fileName);
		
		try{
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(filebytes);
			fos.close();
			System.out.println("File downloaded: " + filePath);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
