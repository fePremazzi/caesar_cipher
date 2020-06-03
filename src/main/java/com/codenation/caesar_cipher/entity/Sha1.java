package com.codenation.caesar_cipher.entity;

public class Sha1 {
	
	private String message;
	private String encriptedMessage;
	
	public Sha1(String message) {
		this.message = message;
		//TODO this.encriptedMessage = Cryptography.Sha1Encoder .....
	}	
	
	public Sha1() {
		this.message = "";
		this.encriptedMessage = "";
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getEncriptedMessage() {
		return encriptedMessage;
	}
	

}
