package main.wsapp.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@XmlRootElement(name = "library")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    @XmlElement
    private List<Book> content;

    public Library() {
        content = new ArrayList<>();
    }

    public List<Book> getContent() {
        return content;
    }

    public int getNewId() {
        if (content.size() == 0) {
            return 1;
        }
        return content.stream().max(Comparator.comparing(Book::getId)).get().getId() + 1;
    }
}
