package com.imokhonko;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {

//    private LocalDate date;
    private Ticket ticket;
    private HistoryTypes type;
    private List<Book> books = new ArrayList<> ();

    public History(Ticket ticket, List<Book> books, HistoryTypes type) {
        this.ticket = ticket;
        this.type = type;
        this.books.addAll(books);
    }

    public History(Ticket ticket, Book book, HistoryTypes type) {
        this.ticket = ticket;
        this.type = type;
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public HistoryTypes getType() {
        return type;
    }
}
