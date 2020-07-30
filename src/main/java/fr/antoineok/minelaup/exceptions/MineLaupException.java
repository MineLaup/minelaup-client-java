package fr.antoineok.minelaup.exceptions;

public class MineLaupException extends Exception{
	public MineLaupException() {
	}
	
	public MineLaupException(String message) {
		super(message);
	}
	
	public MineLaupException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MineLaupException(Throwable cause) {
		super(cause);
	}
	
	public MineLaupException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
