package hu.uni.miskolc.iit.webalk.library.dao;

import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;

import java.util.Collection;

public interface BookDAO {
    Collection<Book> readBooks();

    Book readBookByISBN(Long isbn) throws BookNotFoundException;

    Collection<Book> readBookByStatus(boolean loaned);

    Collection<Book> readAvaiableBookByTitle(String title) throws BookNotFoundException;

    void createBook(Book book) throws BookExistsException, IllegalISBNException, IllegalPublishDateException, NullTitleException, NoAuthorException;

    void updateBook(Book book) throws BookExistsException, NullTitleException, IllegalPublishDateException, IllegalISBNException, NoAuthorException;

    void deleteBook(Long isbn) throws BookNotFoundException;

    Collection<Book> readBooksByAuthor(String author) throws BookNotFoundException;

    int getBookCount();

    Collection<Book> readBooksInYear(int year) throws BookNotFoundException;

    Collection<Book> readBooksSinceYear(int year) throws BookNotFoundException;
}
