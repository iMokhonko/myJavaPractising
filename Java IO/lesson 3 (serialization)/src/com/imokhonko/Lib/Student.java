package com.imokhonko.Lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private final String name;
    private List<Book> books = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student student) {
        this(student.getName ());
    }

    public void setBook(Book book) {
        this.books.add(book);
    }

    public void setBooks(List<Book> books) {
        this.books.addAll (books);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals ( student.name ) : student.name != null) return false;
        return books != null ? books.equals ( student.books ) : student.books == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode () : 0;
        result = 31 * result + (books != null ? books.hashCode () : 0);
        return result;
    }
}
