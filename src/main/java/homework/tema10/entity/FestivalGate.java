package homework.tema10.entity;

import java.util.LinkedList;
import java.util.Queue;

public class FestivalGate {
    public final static Queue<TicketType> ticketQueue = new LinkedList<>();

    public void addTicket(TicketType ticketType)
    {
        synchronized (this) {
            ticketQueue.offer(ticketType);
        }
    }
}
