package hu.uni.miskolc.iit.webalk.library.controller;

import hu.uni.miskolc.iit.webalk.library.controller.dto.BookRequest;
import hu.uni.miskolc.iit.webalk.library.controller.dto.LocalDateAdapter;
import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.model.Genre;
import hu.uni.miskolc.iit.webalk.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DTOController {
    @Autowired
    BookService service;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "addBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(@RequestBody BookRequest book) throws BookExistsException, IllegalISBNException, IllegalPublishDateException, NullTitleException, NoAuthorException, IllegalGenreException, LocalDateUnmarshalException, IllegalIdException {
        service.addBook(new Book(service.getBookCount(), book.getIsbn(), book.getTitle(), book.getAuthor(), new LocalDateAdapter().unmarshal(book.getPublishDate()), book.getGenre(), book.isLoaned()));
        //return "succes";
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "updateBook", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody BookRequest book) throws BookExistsException, LocalDateUnmarshalException, NoAuthorException, NullTitleException, IllegalPublishDateException, IllegalISBNException, IllegalIdException {
        service.updateBook(new Book(service.getBookCount(), book.getIsbn(), book.getTitle(), book.getAuthor(), new LocalDateAdapter().unmarshal(book.getPublishDate()), Genre.valueOf(book.getGenre()), book.isLoaned()));
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong date format, yyyy-MM-dd is the correct")
    @ExceptionHandler(LocalDateUnmarshalException.class)
    public void badDateFormat() {
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "There are already a book with that ISBN")
    @ExceptionHandler(BookExistsException.class)
    public void bookExists() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ISBN must be at least 1")
    @ExceptionHandler(IllegalISBNException.class)
    public void illegalISBN() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "id must be at least 1")
    @ExceptionHandler(IllegalIdException.class)
    public void illegalId() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You can't store an unpublished book in the library")
    @ExceptionHandler(IllegalPublishDateException.class)
    public void illegalDate() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Title field cannot be empty")
    @ExceptionHandler(NullTitleException.class)
    public void emptyTitle() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Author field cannot be empty ")
    @ExceptionHandler(NoAuthorException.class)
    public void emptyAuthor() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not valid Genre")
    @ExceptionHandler(IllegalGenreException.class)
    public void badGenre() {
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not a valid input")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void invalidJson() {
    }

    @ExceptionHandler(Exception.class)
    public String otherExceptions() {
        return "error";
    }
}
