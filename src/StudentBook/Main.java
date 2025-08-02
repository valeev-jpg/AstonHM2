package StudentBook;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Анастия", List.of(
                        new Book("Книга A", 100, 2001),
                        new Book("Книга B", 105, 2006),
                        new Book("Книга C", 150, 2005),
                        new Book("Книга D", 90, 1998),
                        new Book("Книга E", 200, 2010))),
                new Student("Виталий", List.of(
                        new Book("Книга F", 120, 2003),
                        new Book("Книга G", 220, 2015),
                        new Book("Книга H", 130, 2000),
                        new Book("Книга I", 110, 2021),
                        new Book("Книга J", 250, 1995))),
                new Student("Матвей", List.of(
                        new Book("Книга B", 105, 2006),
                        new Book("Книга C", 150, 2005),
                        new Book("Книга D", 90, 1998),
                        new Book("Книга A", 100, 2001),
                        new Book("Книга E", 200, 2010)))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(s -> s.getBooks().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .peek(book -> System.out.println("Уникальная книга: " + book))
                .map(Optional::ofNullable)
                .map(optBook -> optBook.map(book -> {
                    System.out.println("Год выпуска: " + book.getYear());
                    return book;
                }).orElseGet(() -> {
                    System.out.println("Книга не найдена");
                    return null;
                }))
                .collect(Collectors.toList());
    }
}