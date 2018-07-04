package com.imokhonko;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Library library = new Library ("NUFT Lib");
        System.out.println ("LIBRARY NAME: " + library.getName ());

        // adding students
        Student ivan = new Student ("Ivan Mokhonko");
        Student lexa = new Student ("Prosto Lexa");


        library.addBookToLibrary (new Book (1, "Java programming", "Sergey Nemchinskiy"));
        library.addBookToLibrary (new Book (2, "SQL for beginners", "Sanya Zhyk"));
        library.addBookToLibrary (new Book (3, "Unity3D", "Hideo Kodzima"));
        library.addBookToLibrary (new Book (4, "JavaSript ", "Ivan Cool"));
        System.out.println ("Library books:");
        System.out.println (library.getBook(3));




        // show books that was given to students
        library.getConsoleBooks();

    }



}
