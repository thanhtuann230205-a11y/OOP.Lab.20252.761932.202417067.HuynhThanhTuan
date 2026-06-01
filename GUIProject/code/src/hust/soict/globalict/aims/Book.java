package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authorName != null && !authorName.trim().isEmpty() && !authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (!authors.remove(authorName)) {
            throw new IllegalArgumentException("The author is not listed in this book.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }
}
