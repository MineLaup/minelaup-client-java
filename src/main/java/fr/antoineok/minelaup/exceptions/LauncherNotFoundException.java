package fr.antoineok.minelaup.exceptions;

public class LauncherNotFoundException extends  MineLaupException{

    public LauncherNotFoundException() {
    }

    public LauncherNotFoundException(String message) {
        super(message);
    }

    public LauncherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LauncherNotFoundException(Throwable cause) {
        super(cause);
    }

    public LauncherNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
