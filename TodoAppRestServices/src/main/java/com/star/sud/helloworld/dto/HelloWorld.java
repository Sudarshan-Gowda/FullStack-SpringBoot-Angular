package com.star.sud.helloworld.dto;

public class HelloWorld {

	private String message;

	public HelloWorld() {
		super();
	}

	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorld [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

}
