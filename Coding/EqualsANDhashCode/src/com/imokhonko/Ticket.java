package com.imokhonko;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Ticket {

    private int id;
    private List<Book> books;
    private Student student;
//    private LocalDate issuedDate;
//    private LocalDate returnDate;

    public Ticket(int id, List<Book> books, Student student) {
        this.id = id;
        this.books = books;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (books != null ? !books.equals ( ticket.books ) : ticket.books != null) return false;
        return student != null ? student.equals ( ticket.student ) : ticket.student == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (books != null ? books.hashCode () : 0);
        result = 31 * result + (student != null ? student.hashCode () : 0);
        return result;
    }
}
