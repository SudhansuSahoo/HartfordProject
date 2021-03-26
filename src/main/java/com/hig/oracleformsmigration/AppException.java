package com.hig.oracleformsmigration;

public class AppException extends RuntimeException{
	
	AppException (String msg) {
		 super("Exception " + msg);	
	}
}
