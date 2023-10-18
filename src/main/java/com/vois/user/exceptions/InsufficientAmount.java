package com.vois.user.exceptions;
public class InsufficientAmount extends RuntimeException {
	
	public InsufficientAmount(String msg){
		super(msg);
	}
}