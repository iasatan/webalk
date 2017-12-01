package hu.uni.miskolc.iit.webalk.library.dao.inmemory;

import hu.uni.miskolc.iit.webalk.library.dao.BookDAO;
import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.model.Genre;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class BookDAOMem implements BookDAO {
    Collection<Book> books;

    public BookDAOMem() throws NoAuthorException, NullTitleException, IllegalPublishDateException, IllegalISBNException, IllegalIdException {
        books = new ArrayList<Book>();
        books.add(new Book(1, (long) 123123, "Design Patterns", "Eich Gamma", LocalDate.of(1994, 1, 1), Genre.Other, false));
        books.add(new Book(2, (long) 123321, "Microstf .NET Framework 3.5", "Matthew A. Stoecker", LocalDate.of(2008, 1, 1), Genre.Microsoft, true));
        books.add(new Book(3, (long) 321123321, "Microstf .NET Framework 3.5", "Tony Northup", LocalDate.of(2005, 1, 1), Genre.Microsoft, false));
        books.add(new Book(4, Long.valueOf("3211233212"), "Microstf .NET Framework 3.5", "Tony Northup", LocalDate.of(2005, 1, 1), Genre.Microsoft, false));
        books.add(new Book(5, Long.valueOf("32112332122"), "Microstf .NET Framework 3.5asdsada", "Tony Norasdasdthup", LocalDate.of(2017, 1, 1), Genre.Microsoft, false));
    }

    public Collection<Book> readBooks() {
        return books;
    }

    public Book readBookByISBN(Long isbn) throws BookNotFoundException {
        for (Book book : books) {
            if (isbn.equals(book.getIsbn()))
                return book;
        }
        throw new BookNotFoundException(isbn);
    }

    @Override
    public Collection<Book> readBookByStatus(boolean loaned) {
        Collection<Book> bookCollection = new HashSet<>();
        for (Book book : readBooks()) {
            if (book.isLoaned() == loaned)
                bookCollection.add(book);
        }
        return bookCollection;
    }

    @Override
    public Collection<Book> readAvaiableBookByTitle(String title) throws BookNotFoundException {
        Collection<Book> books = new HashSet<Book>();
        Collection<Book> dbBooks = readBooks();
        for (Book book : dbBooks) {
            if (book.isLoaned() == false && StringUtils.containsIgnoreCase(book.getTitle(), title)) {
                if (books.size() < 1) {
                    books.add(book);
                }
                for (Book bookWithTitle : books) {
                    if (!book.equals(bookWithTitle)) {
                        books.add(book);
                        break;
                    }
                }
            }
        }
        if (books.size() < 1)
            throw new BookNotFoundException(title);
        return books;
    }

    public Collection<Book> readBooksByAuthor(String author) throws BookNotFoundException {
        Collection<Book> authorBooks = new HashSet<Book>();
        for (Book book : readBooks()) {
            if (author.equalsIgnoreCase(book.getAuthor()))
                authorBooks.add(book);
        }
        if (authorBooks.size() == 0)
            throw new BookNotFoundException(author);
        return authorBooks;
    }

    @Override
    public int getBookCount() {
        return readBooks().size() + 1;
    }

    @Override
    public Collection<Book> readBooksInYear(int year) throws BookNotFoundException {
        Collection<Book> books = new HashSet<Book>();
        Collection<Book> dbBooks = readBooks();
        for (Book book : dbBooks) {
            if (book.getPublishDate().getYear() == year)
                books.add(book);
        }
        if (books.size() < 1)
            throw new BookNotFoundException(year);
        return books;
    }

    @Override
    public Collection<Book> readBooksSinceYear(int year) throws BookNotFoundException {
        Collection<Book> books = new HashSet<Book>();
        Collection<Book> dbBooks = readBooks();
        for (Book book : dbBooks) {
            if (book.getPublishDate().getYear() >= year)
                books.add(book);
        }
        if (books.size() < 1)
            throw new BookNotFoundException(year);
        return books;
    }

    public void createBook(Book book) throws BookExistsException {
        for (Book memBook : readBooks()) {
            if (memBook.getId().equals(book.getId()))
                throw new BookExistsException(book.getIsbn());
        }
        books.add(book);
    }

    public void updateBook(Book book) throws BookExistsException {
        for (Book libBook : readBooks()) {
            if (libBook.getIsbn().equals(book.getIsbn())) {
                books.remove(libBook);
                break;
            }
        }
        createBook(book);
    }

    public void deleteBook(Long isbn) throws BookNotFoundException {
        Book book = readBookByISBN(isbn);
        books.remove(book);
    }
}
