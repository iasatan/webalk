package hu.uni.miskolc.iit.webalk.library.exceptions;

public class NoAuthorException extends Exception {
    public NoAuthorException() {
        super("Author field cannot be empty");
    }
}
