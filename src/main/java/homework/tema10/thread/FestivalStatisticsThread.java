package homework.tema10.thread;

import homework.tema10.entity.FestivalGate;
import lombok.SneakyThrows;

public class FestivalStatisticsThread extends Thread {
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate){
        this.gate = gate;
    }

    @SneakyThrows
    public void run() {
            System.out.println("statistic ==== ");
            Thread.sleep(10);
    }
}