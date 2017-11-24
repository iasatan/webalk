package hu.uni.miskolc.iit.webalk.library.exceptions;

public class IllegalISBNException extends Exception {
    public IllegalISBNException() {
        super("ISBN must be at least 1");
    }
}
