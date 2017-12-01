package hu.uni.miskolc.iit.webalk.library.controller;

import hu.uni.miskolc.iit.webalk.library.exceptions.BookNotFoundException;
import hu.uni.miskolc.iit.webalk.library.exceptions.IllegalPublishDateException;
import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @RequestMapping("getBooks")
    @ResponseBody
    public Collection<Book> getBooks() {
        return service.getAllBook();
    }

    @RequestMapping("getBook/{isbn}")
    @ResponseBody
    public Book getBook(@PathVariable("isbn") String isbn) throws BookNotFoundException {
        return service.getBookByISBN(Long.valueOf(isbn));
    }

    @RequestMapping("getBookByAuthor/{author}")
    @ResponseBody
    public Collection<Book> getBookByAuthor(@PathVariable("author") String author) throws BookNotFoundException {
        return service.getBooksByAuthor(author);
    }

    @RequestMapping("getBookByYear/{year}")
    @ResponseBody
    public Collection<Book> getBookByYear(@PathVariable("year") int year) throws BookNotFoundException, IllegalPublishDateException {
        return service.getBooksInYear(year);
    }

    @RequestMapping("getBookSinceYear/{year}")
    @ResponseBody
    public Collection<Book> getBookSinceYear(@PathVariable("year") int year) throws BookNotFoundException, IllegalPublishDateException {
        return service.getBooksSinceYear(year);
    }

    @RequestMapping("deleteBook/{isbn}")
    public String deleteBook(@PathVariable("isbn") Long isbn) throws BookNotFoundException {
        service.deleteBook(isbn);
        return "succes";
    }

    @RequestMapping("getNotLoanedBooks")
    @ResponseBody
    public Collection<Book> getAvaiableBooks() {
        return service.getBooksByStatus(true);
    }

    @RequestMapping("getLoanedBooks")
    @ResponseBody
    public Collection<Book> getLoanedBooks() {
        return service.getBooksByStatus(false);
    }

    @RequestMapping("getBookByTitle/{title}")
    @ResponseBody
    public Collection<Book> getBookByTitle(@PathVariable("title") String title) throws BookNotFoundException {
        return service.getAvaiableBookByTitle(title);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You can't search for books that are not yet published")
    @ExceptionHandler(IllegalPublishDateException.class)
    public void illegalPublishDateException() {
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such book")
    @ExceptionHandler(BookNotFoundException.class)
    public void bookNotFoundException() {
    }

}
