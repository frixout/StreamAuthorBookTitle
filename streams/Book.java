package streams;

import java.util.ArrayList;
import java.util.List;

public class Book {
    List<Title> titleList = new ArrayList<>();
    String name;

    public Book(List<Title> titleList, String name) {
        this.titleList = titleList;
        this.name = name;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
