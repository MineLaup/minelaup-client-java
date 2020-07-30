package fr.antoineok.minelaup.exceptions;

public class WrongKeyException extends MineLaupException{
	
	public WrongKeyException() {
	}
	
	public WrongKeyException(String message) {
		super(message);
	}
	
	public WrongKeyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public WrongKeyException(Throwable cause) {
		super(cause);
	}
	
	public WrongKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
