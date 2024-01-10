import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Author{
    private String name;
    private List<Book> bookList = new ArrayList<>();

    public Author(String name, List<Book> bookList){
        this.name = name;
        this.bookList = bookList;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public List<Book> getBookList(){
        return bookList;
    }

    public void setBookList(List<Book> bookList){
        this.bookList = bookList;
    }
}
