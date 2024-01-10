import java.util.*;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Чехов", Arrays.asList(new Book("Вишневый сад",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ"))),
                new Book("Каштанка",Arrays.asList(new Title("ГЛАВА ПЕРВАЯ"),new Title("ГЛАВА ВТОРАЯ")))));
        Author author2 = new Author("Бунин", Arrays.asList(new Book("Темные аллеи",Arrays.asList(new Title("Глава первая"),new Title("Глава вторая"))),
                new Book("Вишневый сад",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ")))));
        Author author3 = new Author("Некрасов", Arrays.asList(new Book("Эгрегоры",Arrays.asList(new Title("Глава первая"),new Title("Глава вторая"))),
                new Book("Монтенегро",Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"),new Title("ДЕЙСТВИЕ ВТОРОЕ")))));
        //импративный подход
        //1
        List<Author> authorList = Arrays.asList(author1,author2,author3);
        authorList.sort(Comparator.comparing(Author::getName));
        out.println("\nОтсортированные авторы по именам:");
        for (Author element: authorList
             ) {
            out.println(element.getName());
        }

        //2
        List<Book> bookList = new ArrayList<>();
        for (Author author: authorList
        ) {
            bookList.addAll(author.getBookList());
        }
        out.println("\nПолученные у авторов книги:");
        for (Book book: bookList
        ) {
            out.println(book.getName());
        }

        //3.1
        bookList.sort(Comparator.comparing(Book::getName));
        out.println("\nОтсортированные книги");
        for (Book book: bookList
        ) {
            out.println(book.getName());
        }

        //4
        Set<Book> bookSet = new TreeSet<>(bookList);
        out.println("\nУникальные названия книг");
        for (Book book: bookSet
        ) {
            out.println(book.getName());
        }

        //5
        List<Title> titleList = new ArrayList<>();
        for (Book book: bookSet
        ) {
            titleList.addAll(book.getTitleList());
        }
        out.println("\nПолученные у книг заголовки:");
        for (Title title: titleList
        ) {
            out.println(title.getName());
        }

        //6.1
        out.println(titleList.size());

        //6.2
        double len = 0;
        for (Title title : titleList
                ) {
            len = title.getName().length() + len;
        }
        out.println(len/titleList.size());

        /*Stream.of(author, author2, author3)
                .sorted(Comparator.comparing(Author::getName))
                .forEach(x -> out.println(x.getName()))
        ;*/


    }
}