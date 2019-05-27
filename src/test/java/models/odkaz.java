package models;

import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

public class odkaz {
    private String title;
    private String author;
    private String message;
    //nechame ako private - radsej na ne siahame pomocou get-erov a set-erov


    public Odkaz(String title, String author, String message) {
        this.title = title;
        this.author = author;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
