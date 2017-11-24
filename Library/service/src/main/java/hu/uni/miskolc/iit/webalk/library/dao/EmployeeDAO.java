package hu.uni.miskolc.iit.webalk.library.dao;

import hu.uni.miskolc.iit.webalk.library.exceptions.BookExistsException;
import hu.uni.miskolc.iit.webalk.library.exceptions.BookNotFoundException;
import hu.uni.miskolc.iit.webalk.library.model.Book;

import java.util.Collection;

public interface EmployeeDAO {
    Collection<Book> readBooks();

    Book readBookByISBN(Integer isbn) throws BookNotFoundException;

    void createBook(Book book) throws BookExistsException;

    void updateBook(Book book);

    void deleteBook(Integer isbn);
}
