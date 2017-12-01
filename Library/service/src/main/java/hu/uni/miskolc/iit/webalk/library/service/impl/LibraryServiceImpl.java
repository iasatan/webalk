package hu.uni.miskolc.iit.webalk.library.service.impl;

import hu.uni.miskolc.iit.webalk.library.model.Book;
import hu.uni.miskolc.iit.webalk.library.model.Genre;
import hu.uni.miskolc.iit.webalk.library.service.BookService;
import hu.uni.miskolc.iit.webalk.library.service.LibraryService;

import java.util.Collection;
import java.util.HashSet;

public class LibraryServiceImpl implements LibraryService {
    BookService service;

    public LibraryServiceImpl(BookService service) {
        this.service = service;
    }

    @Override
    public Collection<String> getAllAuthor() {
        Collection<String> authors = new HashSet<>();
        for (Book book : service.getAllBook()) {
            if (!authors.contains(book.getAuthor()))
                authors.add(book.getAuthor());
        }
        return authors;
    }

    @Override
    public Collection<String> getAllGenre() {
        Collection<String> genres = new HashSet<>();
        for (Enum e : Genre.values()) {
            genres.add(e.name());
        }
        //Collection<String> genres = new ArrayList<String>(EnumSet.allOf(Genre.class));
        return genres;
    }


}
