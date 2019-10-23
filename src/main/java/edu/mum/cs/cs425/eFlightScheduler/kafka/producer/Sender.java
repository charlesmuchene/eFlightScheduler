package edu.mum.cs.cs425.eFlightScheduler.kafka.producer;

import edu.mum.cs.cs425.eFlightScheduler.models.Flight;
import edu.mum.cs.cs425.eFlightScheduler.service.impl.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Optional;
import java.util.Random;

public class Sender {

  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

  @Value("${kafka.topic.json}")
  private String jsonTopic;

  @Autowired
  private KafkaTemplate<String, Flight> kafkaTemplate;
  @Autowired
  private FlightService flightService;

  public void send() {
    Random ran=new Random();
    int id=ran.nextInt(8);
    if(id==0) id+=1;
    Optional<Flight> flight=flightService.findById((long)id);
    Flight flight1=null;
    if(flight.isPresent()){
      flight1=flight.get();
    }
    System.out.println("the generated id :"+id);
    LOGGER.info("sending flight='{}'", flight1.toString());
    kafkaTemplate.send(jsonTopic, flight1);
  }
}
