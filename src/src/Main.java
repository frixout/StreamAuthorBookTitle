import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Чехов", Arrays.asList(new Book("Вишневый сад", Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"), new Title("ДЕЙСТВИЕ ВТОРОЕ"))),
                new Book("Каштанка", Arrays.asList(new Title("ГЛАВА ПЕРВАЯ"), new Title("ГЛАВА ВТОРАЯ")))));
        Author author2 = new Author("Бунин", Arrays.asList(new Book("Темные аллеи", Arrays.asList(new Title("Глава первая"), new Title("Глава вторая"))),
                new Book("Вишневый сад", Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"), new Title("ДЕЙСТВИЕ ВТОРОЕ")))));
        Author author3 = new Author("Некрасов", Arrays.asList(new Book("Эгрегоры", Arrays.asList(new Title("Глава первая"), new Title("Глава вторая"))),
                new Book("Высокие горы", Arrays.asList(new Title("ДЕЙСТВИЕ ПЕРВОЕ"), new Title("ДЕЙСТВИЕ ВТОРОЕ")))));
        //Декларативный подход
        out.println(Stream.of(author1, author2, author3)
                        .sorted(Comparator.comparing(Author::getName))
                        .flatMap(x -> x.getBookList().stream())
                        .sorted(Comparator.comparing(Book::getName))
                        .distinct()
                        .flatMap(x -> x.getTitleList().stream())
                        .peek(x -> out.println(x.getName()))
                        .count()
        );
        out.println(Stream.of(author1, author2, author3)
                        .sorted(Comparator.comparing(Author::getName))
                        .flatMap(x -> x.getBookList().stream())
                        .filter(x -> x.getName().length() < 20 && x.getName().startsWith("В"))
                        .distinct()
                        .flatMap(x -> x.getTitleList().stream())
                        .peek(x -> out.println(x.getName()))
                        .count()
        );
        out.println(Stream.of(author1, author2, author3)
                        .sorted(Comparator.comparing(Author::getName))
                        .flatMap(x -> x.getBookList().stream())
                        .sorted(Comparator.comparing(Book::getName))
                        .distinct()
                        .flatMap(x -> x.getTitleList().stream())
                        .peek(x -> out.println(x.getName()))
                        .mapToInt(x -> x.getName().length())
                        .average()
        );
        out.println(Stream.of(author1, author2, author3)
                        .sorted(Comparator.comparing(Author::getName))
                        .flatMap(x -> x.getBookList().stream())
                        .filter(x -> x.getName().length() < 20 && x.getName().startsWith("В"))
                        .distinct()
                        .flatMap(x -> x.getTitleList().stream())
                        .peek(x -> out.println(x.getName()))
                        .mapToInt(x -> x.getName().length())
                        .average()
        );
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
        List<Book> bookList1 = bookList;

        //3.1
        bookList.sort(Comparator.comparing(Book::getName));
        out.println("\nОтсортированные книги");
        for (Book book: bookList
        ) {
            out.println(book.getName());
        }
        extracted(bookList);

        //3.2
        Iterator<Book> bookIterator = bookList1.iterator();
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if(book.getName().length()>12){
                bookIterator.remove();
            } else if ((book.getName().charAt(0)) != 'В') {
                bookIterator.remove();
            }
        }
        out.println("\nОтфильтрованные книги:");
        for (Book book: bookList1
        ) {
            out.println(book.getName());
        }
        extracted(bookList1);
    }

    private static void extracted(List<Book> bookList1) {
        //4
        Set<Book> bookSet1 = new TreeSet<>(bookList1);
        out.println("\nУникальные названия книг");
        for (Book book : bookSet1
        ) {
            out.println(book.getName());
        }

        //5
        List<Title> titleList1 = new ArrayList<>();
        for (Book book : bookSet1
        ) {
            titleList1.addAll(book.getTitleList());
        }
        out.println("\nПолученные у книг заголовки:");
        for (Title title : titleList1
        ) {
            out.println(title.getName());
        }

        //6.1
        out.println("Количество заголовков: " + titleList1.size());

        //6.2
        double len1 = 0;
        for (Title title : titleList1
        ) {
            len1 = title.getName().length() + len1;
        }
        out.println("Cредняя длина всех заголовков: " + len1 / titleList1.size());
    }
}