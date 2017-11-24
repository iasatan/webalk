package hu.uni.miskolc.iit.webalk.library.model;

import hu.uni.miskolc.iit.webalk.library.exceptions.IllegalISBNException;
import hu.uni.miskolc.iit.webalk.library.exceptions.IllegalPublishDateException;
import hu.uni.miskolc.iit.webalk.library.exceptions.NoAuthorException;
import hu.uni.miskolc.iit.webalk.library.exceptions.NullTitleException;

import java.time.LocalDate;
import java.util.Collection;

public class Book {
    private int ISBN;
    private String title;
    private Collection<String> authors;
    private LocalDate publishDate;
    private Genre genre;

    public Book() {
    }

    public Book(int ISBN, String title, Collection<String> authors, LocalDate publishDate, Genre genre) throws IllegalISBNException, IllegalPublishDateException, NoAuthorException, NullTitleException {
        setISBN(ISBN);
        setAuthors(authors);
        setPublishDate(publishDate);
        setTitle(title);
        this.genre=genre;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) throws IllegalISBNException {
        if(ISBN<=0)
            throw new IllegalISBNException();
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws NullTitleException {
        if(title==null)
            throw new NullTitleException();
        this.title = title;
    }

    public Collection<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<String> authors) throws NoAuthorException {
        if(authors.size()==0)
            throw new NoAuthorException();
        this.authors = authors;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) throws IllegalPublishDateException {
        if (publishDate.isAfter(LocalDate.now()))
            throw new IllegalPublishDateException();
        this.publishDate = publishDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + ISBN +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", publishDate=" + publishDate +
                ", genre=" + genre +
                '}';
    }
}
