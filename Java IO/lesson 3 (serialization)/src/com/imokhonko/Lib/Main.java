package com.imokhonko.Lib;

import com.imokhonko.Lib.exceptions.BooksNotFoundException;
import com.imokhonko.Lib.exceptions.StudentsNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        List<Student> students = new ArrayList<> ();
        List<Book> books = new ArrayList<> ();

        students.add (new Student ("Ivan Mokhonko"));
        students.add (new Student ("Viola Zaritskaya"));
        DBLib.serializeStudents (students);

        books.add (new Book ("JavaScript", "Some guy"));
        books.add (new Book ("SQL", "jove teryer"));
        books.add (new Book ("PHP", "jove teryer"));
        DBLib.serializeBooks (books);

        students.clear ();
        books.clear ();

        try {
            students = DBLib.deserializeStudents ();
        } catch (StudentsNotFoundException e) {
            System.out.println ("studets was not found");
        }

        try {
            books = DBLib.deserializeBooks ();
        } catch (BooksNotFoundException e) {
            System.out.println ("books was not found");
        }


        //DBLib.giveBookToStudent (students.get (1), books);
        DBLib.serializeStudents (students);

        for (Student student : students) {
            System.out.println ("\nName: " + student.getName ());
            System.out.printf ("Books: ");
            System.out.println (student.getBooks ());
            System.out.println ("\n_________________________________");
        }

    }

}
