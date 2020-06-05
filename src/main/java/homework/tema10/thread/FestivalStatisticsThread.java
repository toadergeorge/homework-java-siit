package homework.tema10.thread;

import homework.tema10.entity.FestivalGate;
import homework.tema10.entity.TicketType;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate){
        this.gate = gate;
    }

    @SneakyThrows
    public void run() {

        System.out.println("====================>>> REAL TIME STATISTICS <<<=======================");
        System.out.println(this.gate.ticketQueue.size() + " people entered");

        Map<Object, List<TicketType>> types = this.gate.ticketQueue.stream().collect(Collectors.groupingBy(ticketType -> ticketType));

        types.forEach((mapKey, tiketList) -> {
            if(mapKey == TicketType.valueOf("FULL")){
                System.out.println(tiketList.size() + "  people have full tickets");
            }

            if(mapKey == TicketType.valueOf("FREE_PASS")){
                System.out.println(tiketList.size() + "  have free passes");
            }

            if(mapKey == TicketType.valueOf("FULL_VIP")){
                System.out.println(tiketList.size() + "  have full VIP passess");
            }

            if(mapKey == TicketType.valueOf("ONE_DAY")){
                System.out.println(tiketList.size() + "  have one-day passes");
            }

            if(mapKey == TicketType.valueOf("ONE_DAY_VIP")){
                System.out.println(tiketList.size() + "  one-day VIP passes");
            }
        });

        System.out.println("=======================================================================");

        Thread.sleep(10);
    }
}