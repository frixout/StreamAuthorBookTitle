package streams;

import java.util.ArrayList;
import java.util.List;

public class Author {
    List<Book> bookList = new ArrayList<>();

    String name;

    public Author(List<Book> bookList, String name) {
        this.bookList = bookList;
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
