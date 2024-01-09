package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainNew {
    public static void main(String[] args) {
        List<Author> authors = new ArrayList<>();

        authors.add(
                new Author(List.of(
                        new Book(List.of(
                                new Title("Title"),
                                new Title("Title2")
                        ),
                                "Book")
                ),
                        "John")
        );

        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .flatMap(book -> book.getTitleList().stream())
                .map(title -> title.getName())
                .map(s -> s.length());

        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .filter(book -> book.getName().startsWith("B"))
                .flatMap(book -> book.getTitleList().stream())
                .sorted(Comparator.comparing(title -> title.getName().length()))
                .map(title -> title.getName())
                .map(s -> s.length());

        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .flatMap(book -> book.getTitleList().stream())
                .count();

        authors.stream()
                .flatMap(author -> author.getBookList().stream())
                .flatMap(book -> book.getTitleList().stream())
                .map(title -> title.getName().length())
                .mapToInt(value -> value)
                .average();
    }
}

