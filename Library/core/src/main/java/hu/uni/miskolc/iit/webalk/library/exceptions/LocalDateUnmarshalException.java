package hu.uni.miskolc.iit.webalk.library.exceptions;

public class LocalDateUnmarshalException extends Exception {
    public LocalDateUnmarshalException() {
        super("Wrong Time Format, yyyy-MM-dd is the correct one");
    }
}
