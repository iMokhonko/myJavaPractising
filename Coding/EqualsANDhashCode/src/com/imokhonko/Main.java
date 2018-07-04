package com.imokhonko;


import com.imokhonko.consoleViews.ConsoleView;

public class Main {

    public static void main(String[] args) {

        Library library = new Library ("NUFT Lib");
        ConsoleView consoleView = new ConsoleView ();

        // adding students
        Student ivan = new Student ("Ivan Mokhonko");

        library.addBookToLibrary (new Book (1, "Java programming", "Sergey Nemchinskiy"));
        library.addBookToLibrary (new Book (2, "SQL for beginners", "Sanya Zhyk"));
        library.addBookToLibrary (new Book (3, "Unity3D", "Hideo Kodzima"));
        library.addBookToLibrary (new Book (4, "JavaSript ", "Ivan Cool"));

        Ticket ticket = new Ticket (1, library.getBooks(), ivan);
        library.addTicket (ticket);

       library.returnTicket (ticket, library.getBook(2));

        consoleView.getConsoleHistory (library.getHistory ());


    }



}
