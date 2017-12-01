package hu.uni.miskolc.iit.webalk.library.exceptions;

public class IllegalGenreException extends Exception {
    public IllegalGenreException(String genre) {
        super("No such Genre: " + genre);
    }
}
