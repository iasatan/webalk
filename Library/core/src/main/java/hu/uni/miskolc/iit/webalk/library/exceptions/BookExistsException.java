package hu.uni.miskolc.iit.webalk.library.exceptions;

public class BookExistsException extends Exception {
    public BookExistsException(long isbn) {
        super("Book already exists with " + isbn + " ISBN number");
    }
}
