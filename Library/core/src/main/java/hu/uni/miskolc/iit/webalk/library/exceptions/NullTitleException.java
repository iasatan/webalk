package hu.uni.miskolc.iit.webalk.library.exceptions;

public class NullTitleException extends Exception {
    public NullTitleException() {
        super("Title cannot be empty");
    }
}
