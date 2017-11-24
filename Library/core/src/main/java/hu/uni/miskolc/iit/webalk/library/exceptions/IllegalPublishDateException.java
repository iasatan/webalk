package hu.uni.miskolc.iit.webalk.library.exceptions;

public class IllegalPublishDateException extends Exception {
    public IllegalPublishDateException() {
        super("You can't store an unpublished book in the library");
    }
}
