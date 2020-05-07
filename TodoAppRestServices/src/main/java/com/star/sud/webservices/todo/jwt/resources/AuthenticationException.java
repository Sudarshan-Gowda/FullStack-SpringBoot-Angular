package com.star.sud.webservices.todo.jwt.resources;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = -8968616199846325991L;

	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
