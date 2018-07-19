package com.imokhonko.Lib;

import com.imokhonko.Lib.exceptions.BooksNotFoundException;
import com.imokhonko.Lib.exceptions.StudentsNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBLib {

    private final static String DIRECTORY_STUDENTS = "students";
    private final static String DIRECTORY_BOOKS = "books";

    public static void serializeStudents(List<Student> students) {
        File studentsDirectory = new File (DIRECTORY_STUDENTS);
        if(!studentsDirectory.exists ())
            studentsDirectory.mkdir ();

        for (Student student : students) {
            File isExistStudent = new File(studentsDirectory + "/" + student.getName () + ".info");
            if(isExistStudent.exists ())
                continue;
            try (ObjectOutputStream writeObject = new ObjectOutputStream (new FileOutputStream(studentsDirectory + "/" + student.getName () + ".info"))) {
                writeObject.writeObject (student);
            } catch (IOException e) {
                System.out.println ("error");
            }
        }
    }

    public static List<Student> deserializeStudents() throws StudentsNotFoundException {
        File studentsDirectory = new File (DIRECTORY_STUDENTS);

        List<Student> students = new ArrayList<> ();

        for (String student : studentsDirectory.list ()) {
            File checkFile = new File(DIRECTORY_STUDENTS + "/" + student);
            if(!checkFile.isDirectory ()) {
                try (ObjectInputStream readObject = new ObjectInputStream (new FileInputStream (DIRECTORY_STUDENTS + "/" + student))) {
                    students.add((Student) readObject.readObject ());
                } catch (IOException e) {
                    System.out.println ("error reading object");
                } catch (ClassNotFoundException e) {
                    System.out.println ("class not found");
                }
            }
        }

        if(students.isEmpty ())
            throw new StudentsNotFoundException ();

        return students;
    }

    public static void serializeBooks(List<Book> books) {
        File booksDirectory = new File (DIRECTORY_BOOKS);
        if(!booksDirectory.exists ())
            booksDirectory.mkdir ();

        for (Book book : books) {
            File isExistBook = new File(booksDirectory + "/" + book.getTitle () + " (" + book.getAuthor () + ")" + ".info");
            if(isExistBook.exists ())
                continue;
            try (ObjectOutputStream writeObject = new ObjectOutputStream (new FileOutputStream(booksDirectory + "/" + book.getTitle () + " (" + book.getAuthor () + ")" + ".info"))) {
                writeObject.writeObject (book);
            } catch (IOException e) {
                System.out.println ("error");
            }
        }
    }

    public static List<Book> deserializeBooks() throws BooksNotFoundException {
        File booksDirectory = new File (DIRECTORY_BOOKS);

        List<Book> books = new ArrayList<> ();

        for (String book : booksDirectory.list ()) {
            File checkFile = new File(DIRECTORY_BOOKS + "/" + book);
            if(!checkFile.isDirectory ()) {
                try (ObjectInputStream readObject = new ObjectInputStream (new FileInputStream (DIRECTORY_BOOKS + "/" + book))) {
                    books.add((Book) readObject.readObject ());
                } catch (IOException e) {
                    System.out.println ("error");
                } catch (ClassNotFoundException e) {
                    System.out.println ("class not found");
                }
            }
        }

        if(books.isEmpty ())
            throw new BooksNotFoundException ();

        return books;
    }

    public static void giveBookToStudent(Student student, Book book) {
        student.setBook(book);
    }

    public static void giveBookToStudent(Student student, List<Book> books) {
        student.setBooks(books);
    }

}
