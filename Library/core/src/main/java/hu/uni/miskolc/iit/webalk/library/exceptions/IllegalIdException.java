package hu.uni.miskolc.iit.webalk.library.exceptions;

public class IllegalIdException extends Exception {
    public IllegalIdException() {
        super("Id cannot be lower than 1");
    }
}
