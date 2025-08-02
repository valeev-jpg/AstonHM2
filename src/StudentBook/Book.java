package StudentBook;
import java.util.Objects;

public class Book {
    private final String title;
    private final int pages;
    private final int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    public String getTitle() { return title; }
    public int getPages() { return pages; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return title + " (" + pages + " стр., " + year + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, pages, year);
    }
}
