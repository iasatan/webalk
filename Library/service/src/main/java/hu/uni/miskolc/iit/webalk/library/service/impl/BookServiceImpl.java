package hu.uni.miskolc.iit.webalk.library.service.impl;

import hu.uni.miskolc.iit.webalk.library.dao.BookDAO;
import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.service.BookService;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {

    BookDAO dao;

    public BookServiceImpl(BookDAO dao) {
        this.dao = dao;
    }

    public void addBook(Book book) throws BookExistsException, IllegalISBNException, IllegalPublishDateException, NullTitleException, NoAuthorException {
        if (book.getIsbn() < 1)
            throw new IllegalISBNException();
        if (book.getPublishDate().isAfter(LocalDate.now()))
            throw new IllegalPublishDateException();
        if (book.getTitle().length() < 1 || book.getTitle() == null)
            throw new NullTitleException();
        if (book.getAuthor().length() < 1 || book.getAuthor() == null)
            throw new NoAuthorException();
        dao.createBook(book);
    }


    public void deleteBook(Long isbn) throws BookNotFoundException {
        dao.deleteBook(isbn);

    }

    public void updateBook(Book book) throws BookExistsException, NullTitleException, IllegalPublishDateException, IllegalISBNException, NoAuthorException {
        if (book.getIsbn() < 1)
            throw new IllegalISBNException();
        if (book.getPublishDate().isAfter(LocalDate.now()))
            throw new IllegalPublishDateException();
        if (book.getTitle().length() < 1 || book.getTitle() == null)
            throw new NullTitleException();
        if (book.getAuthor().length() < 1 || book.getAuthor() == null)
            throw new NoAuthorException();
        dao.updateBook(book);
    }

    public Collection<Book> getAllBook() {
        return dao.readBooks();
    }

    public Book getBookByISBN(Long isbn) throws BookNotFoundException {
        return dao.readBookByISBN(isbn);
    }

    @Override
    public Collection<Book> getBooksByAuthor(String author) throws BookNotFoundException {
        return dao.readBooksByAuthor(author);
    }

    @Override
    public Collection<Book> getBooksByStatus(boolean loaned) {
        return dao.readBookByStatus(loaned);
    }

    @Override
    public Collection<Book> getAvaiableBookByTitle(String title) throws BookNotFoundException {
        return dao.readAvaiableBookByTitle(title);
    }

    @Override
    public int getBookCount() {
        return dao.getBookCount();
    }

    @Override
    public Collection<Book> getBooksInYear(int year) throws IllegalPublishDateException, BookNotFoundException {
        if (LocalDate.now().isBefore(LocalDate.of(year, 01, 01)))
            throw new IllegalPublishDateException();
        return dao.readBooksInYear(year);
    }

    @Override
    public Collection<Book> getBooksSinceYear(int year) throws IllegalPublishDateException, BookNotFoundException {
        if (LocalDate.now().isBefore(LocalDate.of(year, 01, 01)))
            throw new IllegalPublishDateException();
        return dao.readBooksSinceYear(year);
    }


}
