package hu.uni.miskolc.iit.webalk.library.dao.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import hu.uni.miskolc.iit.webalk.library.exceptions.BookExistsException;
import hu.uni.miskolc.iit.webalk.library.exceptions.BookNotFoundException;
import hu.uni.miskolc.iit.webalk.library.model.Book;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class BookDAOJSON implements hu.uni.miskolc.iit.webalk.library.dao.EmployeeDAO {
    ObjectMapper mapper;

    File database;

    public BookDAOJSON(String fileName) {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        database = new File(fileName);
        if (!database.exists()) {
            try {
                database.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Collection<Book> readBooks() {
        Collection<Book> books = new HashSet<Book>();
        try {
            System.out.println(database.getAbsoluteFile());
            books = mapper.readValue(database, new TypeReference<HashSet<Book>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book readBookByISBN(Integer isbn) throws BookNotFoundException {

        Collection<Book> books = new HashSet<Book>();

        try {
            books = mapper.readValue(database, new TypeReference<HashSet<Book>>() {
            });
            for (Book book : books) {
                if (book.getISBN() == isbn)
                    return book;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new BookNotFoundException(isbn);
    }

    public void createBook(Book book) throws BookExistsException {
        Collection<Book> books = readBooks();
        boolean duplicate = false;
        for (Book b : books) {
            if (b.getISBN() == book.getISBN()) {
                duplicate = true;
                break;
            }

        }
        if (duplicate)
            throw new BookExistsException(book.getISBN());
        books.add(book);
        try {
            mapper.writeValue(database, books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(Book book) {

    }

    public void deleteBook(Integer isbn) {

    }
}
