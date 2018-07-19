package com.imokhonko.Lib;

import java.io.Serializable;

public class Book implements Serializable {

    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(Book book) {
        this(book.getTitle (), book.getAuthor ());
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
