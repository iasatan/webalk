package hu.uni.miskolc.iit.webalk.library.exceptions;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(Long isbn) {
        super("No such book with ISBN: " + isbn);
    }

    public BookNotFoundException(String param) {
        super("No book found with this parameter: " + param);
    }

    public BookNotFoundException(int year) {
        super("No books found that are published in " + year);
    }
}
