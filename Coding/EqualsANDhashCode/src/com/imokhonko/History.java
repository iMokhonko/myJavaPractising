package com.imokhonko;

import java.time.LocalDate;

public class History {

//    private LocalDate date;
    private Ticket ticket;
    private HistoryTypes type;

    public History(Ticket ticket, HistoryTypes type) {
        this.ticket = ticket;
        this.type = type;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public HistoryTypes getType() {
        return type;
    }
}
