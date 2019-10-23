package edu.mum.cs.cs425.eFlightScheduler.controller;

import edu.mum.cs.cs425.eFlightScheduler.models.Schedule;
import edu.mum.cs.cs425.eFlightScheduler.models.ScheduleDTO;
import edu.mum.cs.cs425.eFlightScheduler.service.IScheduleService;
import edu.mum.cs.cs425.eFlightScheduler.service.impl.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Schedule api controller
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/eflight/api/schedule")
public class ScheduleApiController {

    private IScheduleService service;

    @Autowired
    public ScheduleApiController(ScheduleService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Schedule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{cursor}")
    public List<Schedule> getAllFrom(@PathVariable Long cursor) {
        return service.getAllFrom(cursor);
    }

    @PostMapping("/")
    public ResponseEntity<Schedule> scheduleFlight(@RequestBody ScheduleDTO scheduleDTO) {
        Optional<Schedule> scheduleOptional = service.save(scheduleDTO);
        return scheduleOptional.isPresent() ? ResponseEntity.status(HttpStatus.CREATED).body(scheduleOptional.get())
                : ResponseEntity.unprocessableEntity().build();
    }
}
