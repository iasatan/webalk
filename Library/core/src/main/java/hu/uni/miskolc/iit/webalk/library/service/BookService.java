package hu.uni.miskolc.iit.webalk.library.service;

import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;

import java.util.Collection;

public interface BookService {

    void addBook(Book book) throws BookExistsException, IllegalISBNException, IllegalPublishDateException, NullTitleException, NoAuthorException;

    void deleteBook(Long isbn) throws BookNotFoundException;

    void updateBook(Book book) throws BookExistsException, NullTitleException, IllegalPublishDateException, IllegalISBNException, NoAuthorException;

    Collection<Book> getAllBook();

    Book getBookByISBN(Long isbn) throws BookNotFoundException;

    Collection<Book> getBooksByAuthor(String author) throws BookNotFoundException;

    Collection<Book> getBooksByStatus(boolean loaned);

    Collection<Book> getAvaiableBookByTitle(String title) throws BookNotFoundException;

    int getBookCount();

    Collection<Book> getBooksInYear(int year) throws IllegalPublishDateException, BookNotFoundException;

    Collection<Book> getBooksSinceYear(int year) throws IllegalPublishDateException, BookNotFoundException;


}
