package hu.uni.miskolc.iit.webalk.library.dao.inmemory;

import hu.uni.miskolc.iit.webalk.library.dao.BookDAO;
import hu.uni.miskolc.iit.webalk.library.exceptions.*;
import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.model.Genre;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;

public class BookDAOMemTest {
    BookDAO dao;

    //@Before
    public void setUp() {
        try {
            dao = new BookDAOMem();
        } catch (NoAuthorException e) {
            e.printStackTrace();
        } catch (NullTitleException e) {
            e.printStackTrace();
        } catch (IllegalPublishDateException e) {
            e.printStackTrace();
        } catch (IllegalISBNException e) {
            e.printStackTrace();
        } catch (IllegalIdException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readBooks() throws Exception {
        Collection<Book> books = dao.readBooks();
        for (Book book : books)
            System.out.println(book);
        System.out.println("\n");
    }

    @Test
    public void readBookByISBN() throws Exception {
    }

    @Test
    public void createBook() throws Exception {
        dao.createBook(new Book(4, (long) 23, "asd", "dsa", LocalDate.now(), Genre.Crimi, true));
        readBooks();
    }

    @Test
    public void updateBook() throws Exception {
        dao.updateBook(new Book(3, (long) 23, "fuck", "this", LocalDate.now(), Genre.Holy, true));
        readBooks();
    }

    @Test
    public void deleteBook() throws Exception {
        for (Enum e : Genre.values()) {
            System.out.println(e.name());
        }
    }

    @Test
    public void findCaseSensiviteTitle() {
        System.out.println(StringUtils.containsIgnoreCase("cicA", "ica"));
    }

}