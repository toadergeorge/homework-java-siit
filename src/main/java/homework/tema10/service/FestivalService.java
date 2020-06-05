package homework.tema10.service;

import homework.tema10.entity.FestivalGate;
import homework.tema10.entity.TicketType;
import homework.tema10.thread.FestivalAttendeeThread;
import homework.tema10.thread.FestivalStatisticsThread;

import java.util.TimerTask;
import java.util.concurrent.*;

public class FestivalService {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        FestivalGate festivalGate = new FestivalGate();

        TimerTask statsTask = new TimerTask() {
            @Override
            public void run() {
                FestivalStatisticsThread statsThread = new FestivalStatisticsThread(festivalGate);
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
        ScheduledFuture newAttendeeEnter= scheduledExecutorService.scheduleAtFixedRate(attendeeTask,1,1, TimeUnit.SECONDS);

        try {
            System.out.println("result = " + scheduledFuture.get());
            System.out.println("result = " + newAttendeeEnter.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //scheduledExecutorService.shutdown();

    }
}
