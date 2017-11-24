package hu.uni.miskolc.iit.webalk.library.service;

import hu.uni.miskolc.iit.webalk.library.model.Book;

import java.util.Collection;

public interface BookService {

    void addBook(Book book);

    void deleteBook(Integer isbn);

    void updateBook(Book book);

    Collection<Book> getAllBook();

    Book getBookByISBN(Integer isbn);
}
