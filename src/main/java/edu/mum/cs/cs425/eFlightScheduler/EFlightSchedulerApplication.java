package edu.mum.cs.cs425.eFlightScheduler;

import edu.mum.cs.cs425.eFlightScheduler.kafka.producer.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EFlightSchedulerApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

   @Autowired
   private Sender sender;


    public static void main(String[] args) {
        SpringApplication.run(EFlightSchedulerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Running EFlight Scheduling System");
        Runnable senderRunnable = () -> {
            while(true) {

                System.out.println("Sending To Kafka broker");
                sender.send();
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Thread senderThread = new Thread(senderRunnable);
        senderThread.start();
    }
}

