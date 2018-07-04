package com.imokhonko;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private List<Book> books = new ArrayList<> ();
    private List<Ticket> tickets = new ArrayList<>();
    private List<History> history = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // adding books to library
    public boolean addBookToLibrary(Book book) {
        books.add (book);
        return true;
    }

    public boolean addBookToLibrary(List<Book> books) {
        this.books.addAll (books);
        return true;
    }

    // returns the books list
    public List<Book> getBooks() {
        return books;
    }

    // returns specific book by parameter
    public Book getBook(Book book) {
        return books.indexOf(book) != -1 ? books.get(books.indexOf(book)) : null;
    }

    public Book getBook(int bookId) {
        for (Book book : books) {
            if(book.getId () == bookId)
                return book;
        }
        return null;
    }

    // add a ticket to student (it allows him to borrow books)
    public boolean addTicket(Ticket ticket) {
        tickets.add (ticket);
        history.add (new History (ticket, HistoryTypes.GIVE));
        return true;
    }

    // removes ticket
    public boolean returnTicket(Ticket ticket) {
        tickets.remove (ticket);
        history.add (new History (ticket, HistoryTypes.RETURN));
        return true;
    }


    // returns history
    public List<History> getHistory() {
        return history;
    }

    // show list of tickets
    public List<Ticket> getTickets() {
        return tickets;
    }


}
