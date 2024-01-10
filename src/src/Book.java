import java.util.*;

public class Book implements Comparable<Book>{
    private String name;
    private List<Title> titleList = new ArrayList<>();

    public Book(String name, List<Title> titleList) {
        this.name = name;
        this.titleList = titleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() !=this.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return name.equals(book.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
