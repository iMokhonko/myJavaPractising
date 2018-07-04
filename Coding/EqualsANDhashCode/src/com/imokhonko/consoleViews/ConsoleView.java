package com.imokhonko.consoleViews;

import com.imokhonko.Book;
import com.imokhonko.History;
import com.imokhonko.HistoryTypes;
import com.imokhonko.Ticket;

import java.util.List;

public class ConsoleView {

    public void getBooks(List<Ticket> tickets) {
        System.out.println ("------------TICKETS------------");
        for (Ticket ticket : tickets) {
            System.out.println ("Ticket id: " + ticket.getId());
            System.out.println ("Student: " + ticket.getStudent().getName());
            System.out.println ("Books:");
            for (Book book : ticket.getBooks ()) {
                System.out.println (book.getTitle () + " (" + book.getAuthor () + ")");
            }
            System.out.println ("________________________");
        }
    }

    public void getConsoleHistory(List<History> historyList) {
        System.out.println ("------------HISTORY------------");

        for (History history : historyList) {
            System.out.println ("Ticket id: " + history.getTicket ().getId ());
            System.out.println ("Student: " + history.getTicket ().getStudent ().getName ());
            System.out.println ("Type: " + history.getType ());

            switch (history.getType ()) {
                case RETURN: {
                    System.out.println ("Books:");
                    givenBooks(history.getBooks ());
                    break;
                }
                case PARTIAL_RETURN: {
                    System.out.println ("Returned books:");
                    givenBooks(history.getBooks ());
                    break;
                }
                case GIVE: {
                    System.out.println ("Gived books:");
                    givenBooks(history.getBooks ());
                    break;
                }
            }


            System.out.println ("________________________");
        }
    }

    private void givenBooks(List<Book> books) {
        for (Book historyBooks : books) {
            System.out.println (historyBooks);
        }
    }

}
