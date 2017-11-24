package hu.uni.miskolc.iit.webalk.library.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(Integer isbn) {
        super("No such book with ISBN: "+isbn);
    }
}
