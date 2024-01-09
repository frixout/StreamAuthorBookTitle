import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("Чехов", Arrays.asList(new Book("Вишневый сад",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ"))),
                new Book("Каштанка",Arrays.asList(new Title("ГЛАВА ПЕРВАЯ"),new Title("ГЛАВА ВТОРАЯ")))));
        Author author2 = new Author("Бунин", Arrays.asList(new Book("Темные аллеи",Arrays.asList(new Title("Глава первая"),new Title("Глава вторая"))),
                new Book("Суходол",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ")))));
        Author author3 = new Author("Некрасов", Arrays.asList(new Book("Эгрегоры",Arrays.asList(new Title("Глава первая"),new Title("Глава вторая"))),
                new Book("Монтенегро",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ")))));

        Stream.of(author, author2, author3)
                .sorted(Comparator.comparing(Author::getName))
                .forEach(x -> out.println(x.getName()))

        ;


    }
}