package homework.tema10.thread;

import homework.tema10.entity.FestivalGate;
import homework.tema10.entity.TicketType;
import lombok.SneakyThrows;

public class FestivalAttendeeThread extends Thread {

    private FestivalGate festivalGate;
    private TicketType ticketType;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.festivalGate   = gate;
        this.ticketType     = ticketType;

    }

    @SneakyThrows
    public void run(String s) {

        System.out.println("client ==== " + this.ticketType.name());

        this.festivalGate.ticketQueue.offer(this.ticketType);
        Thread.sleep(5);
    }
}
