package edu.mum.cs.cs425.eFlightScheduler.kafka.consumer;

import edu.mum.cs.cs425.eFlightScheduler.models.Flight;
import edu.mum.cs.cs425.eFlightScheduler.models.ScheduleDTO;
import edu.mum.cs.cs425.eFlightScheduler.service.IScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);
  @Autowired
  IScheduleService iScheduleService;

  public CountDownLatch getLatch() {

    return latch;
  }

  @KafkaListener(topics = "${kafka.topic.json}")
  public void receive(Flight flight){
    Random ran=new Random();
    String status="";
    int threshold=ran.nextInt(4);
    if (flight.getId()>threshold){
      status+="takeoff";
    }else{
      status+="landing";
    }
//    Date date = new Date();
//    Instant instant = date.toInstant();

    // obj.put("flightId", flight.getId());
    // obj.put("status",status);
    // obj.put("time",Instant.now());

    ScheduleDTO dto =new ScheduleDTO(flight.getId(),status, Instant.now().toString());
    iScheduleService.save(dto);
    // System.out.println("received Json object is "+obj);
    // LOGGER.info("received flight='{}'", obj);
    latch.countDown();
  }

}
