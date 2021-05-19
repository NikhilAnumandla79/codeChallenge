package com.playermanagement.exceptions;

public class MyException extends Exception{
	
	public MyException(){
		super();
	}
	public MyException(Throwable e){
		super(e);
	}
	public MyException(String mesg,Throwable e){
		super(mesg,e);
	}
	public MyException(String mesg){
		super(mesg);
	}

}
