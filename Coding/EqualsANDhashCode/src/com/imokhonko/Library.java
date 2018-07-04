package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Library {

    private String name;
    private List<Book> books = new ArrayList<> ();
    private List<Ticket> tickets = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addBookToLibrary(Book book) {
        books.add (book);
        return true;
    }

    public boolean addBookToLibrary(List<Book> books) {
        this.books.addAll (books);
        return true;
    }

    public List<Book> getBooks() {
        return books;
    }

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


    public boolean addTicket(Ticket ticket) {
        tickets.add (ticket);
        return true;
    }

    public boolean removeTicket(Ticket ticket) {
        tickets.remove (ticket);
        return true;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void getConsoleBooks() {
        for (Ticket ticket : tickets) {
            System.out.println ("----------------------------------------");
            System.out.println ("Ticket id: " + ticket.getId());
            System.out.println ("Student: " + ticket.getStudent().getName());
            System.out.println ("Books:");
            for (Book book : ticket.getBooks ()) {
                System.out.println (book.getTitle () + " (" + book.getAuthor () + ")");
            }
        }
    }

}
