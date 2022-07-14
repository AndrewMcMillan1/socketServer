package com.quintrix.assignments;

import java.io.*;
import java.net.*;

public class socketServer {
			
	public static void main(String[] args) throws IOException {
		
		if (args.length < 1) return;		 
        int port = Integer.parseInt(args[0]);
        
        try {
        	ServerSocket ss = new ServerSocket(port);
    		
    		while(!ss.isClosed()) {
    			
    			Socket cs = ss.accept();   			
    			handleConnection(cs);    		      	        	
        }
	}
        catch (IOException e) {
            e.printStackTrace();	
        }
	}

	private static void handleConnection(Socket s) throws IOException {
		
		try {			
			String str;				 
            do {
            	str = new String(s.getInputStream().readAllBytes());           	
        	    System.out.println("message" + str); 
            } while (!str.equals("exit"));
 
            s.close();
        } catch (IOException e) {           
            e.printStackTrace();
        }
    }
}
		
	    
	


