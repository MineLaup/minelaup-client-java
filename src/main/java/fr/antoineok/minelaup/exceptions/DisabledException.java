package fr.antoineok.minelaup.exceptions;

public class DisabledException extends MineLaupException {
	
	public DisabledException() {
	}
	
	public DisabledException(String message) {
		super(message);
	}
	
	public DisabledException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DisabledException(Throwable cause) {
		super(cause);
	}
	
	public DisabledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
