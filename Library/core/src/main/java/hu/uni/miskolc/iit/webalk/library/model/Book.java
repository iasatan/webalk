package hu.uni.miskolc.iit.webalk.library.model;

import hu.uni.miskolc.iit.webalk.library.exceptions.*;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private Long isbn;
    private String title;
    private String author;
    private LocalDate publishDate;
    private boolean loaned;
    private Genre genre;

    public Book() {
    }

    public Book(Integer id, Long isbn, String title, String author, LocalDate publishDate, String genre, boolean loaned) throws IllegalGenreException, IllegalISBNException, NoAuthorException, IllegalPublishDateException, NullTitleException, IllegalIdException {
        setId(id);
        setIsbn(isbn);
        setAuthor(author);
        setPublishDate(publishDate);
        setTitle(title);
        try {
            this.genre = Genre.valueOf(genre);
        } catch (IllegalArgumentException e) {
            throw new IllegalGenreException(genre);
        }
        this.loaned = loaned;
    }

    public Book(Integer id, Long isbn, String title, String author, LocalDate publishDate, Genre genre, boolean loaned) throws IllegalISBNException, IllegalPublishDateException, NoAuthorException, NullTitleException, IllegalIdException {
        setId(id);
        setIsbn(isbn);
        setAuthor(author);
        setPublishDate(publishDate);
        setTitle(title);
        this.genre = genre;
        this.loaned = loaned;

    }

    public Book(Long isbn, String title, String author, LocalDate publishDate, String genre, boolean loaned) throws IllegalGenreException, IllegalISBNException, NoAuthorException, IllegalPublishDateException, NullTitleException, IllegalIdException {
        setIsbn(isbn);
        setAuthor(author);
        setPublishDate(publishDate);
        setTitle(title);
        try {
            this.genre = Genre.valueOf(genre);
        } catch (IllegalArgumentException e) {
            throw new IllegalGenreException(genre);
        }
        this.loaned = loaned;
    }

    public Book(Long isbn, String title, String author, LocalDate publishDate, Genre genre, boolean loaned) throws IllegalISBNException, IllegalPublishDateException, NoAuthorException, NullTitleException, IllegalIdException {
        setIsbn(isbn);
        setAuthor(author);
        setPublishDate(publishDate);
        setTitle(title);
        this.genre = genre;
        this.loaned = loaned;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws IllegalIdException {
        if (id < 1)
            throw new IllegalIdException();
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws NullTitleException {
        if (title == null)
            throw new NullTitleException();
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws NoAuthorException {
        if (author != null || author.length() >= 2)
            this.author = author;
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

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) throws IllegalISBNException {
        if (isbn <= 0)
            throw new IllegalISBNException();
        this.isbn = isbn;
    }

    public boolean isLoaned() {

        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + isbn +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publishDate=" + publishDate +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (publishDate != null ? !publishDate.equals(book.publishDate) : book.publishDate != null) return false;
        return genre == book.genre;
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (loaned ? 1 : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
