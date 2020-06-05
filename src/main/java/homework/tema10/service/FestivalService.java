package homework.tema10.service;

import homework.tema10.entity.FestivalGate;
import homework.tema10.entity.TicketType;
import homework.tema10.thread.FestivalAttendeeThread;
import homework.tema10.thread.FestivalStatisticsThread;
import lombok.SneakyThrows;

import java.util.TimerTask;
import java.util.concurrent.*;

public class FestivalService {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        FestivalGate festivalGate = new FestivalGate();

        TimerTask statsTask = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                FestivalStatisticsThread statsThread = new FestivalStatisticsThread(festivalGate);
                statsThread.start();
                statsThread.join();
                statsThread = new FestivalStatisticsThread(festivalGate);
                statsThread.start();
            };
        };

        TimerTask attendeeTask = new TimerTask() {
            @Override
            public void run() {
                FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(TicketType.getRandom(), festivalGate);
                festivalAttendee.start();
            };
        };

        ScheduledFuture scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(statsTask,5,5, TimeUnit.SECONDS);
        ScheduledFuture newAttendeeEnter= scheduledExecutorService.scheduleAtFixedRate(attendeeTask,3,3, TimeUnit.SECONDS);

        //scheduledExecutorService.shutdown();

    }
}
