package com.wittybrains.busbookingsystem.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.DateTimeParseException;

import com.wittybrains.busbookingsystem.dto.TravelScheduleDTO;

import com.wittybrains.busbookingsystem.service.TravelScheduleService;

@RestController
@RequestMapping("/schedules")
public class TravelScheduleController {

    @Autowired
    private TravelScheduleService travelScheduleService;

    @GetMapping("avalibility")
    public ResponseEntity<TravelScheduleResponseWrapper> getSchedules(
            @RequestParam("source") String source,
            @RequestParam("destination") String destination,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String date) {

        try {
            LocalDate parsedDate = LocalDate.parse(date);
            List<TravelScheduleDTO> schedules = travelScheduleService.getAvailableSchedules(source, destination, parsedDate);
            if (schedules.isEmpty()) {
                String message = "No bus is available between " + source + " and " + destination + " on " + date;
                TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper(message, schedules);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper("", schedules);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (DateTimeParseException ex) {
            TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper("Invalid date format. The correct format is ISO date format (yyyy-MM-dd)", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<TravelScheduleResponseWrapper> createSchedule(@RequestBody TravelScheduleDTO travelScheduleDTO) throws ParseException {
        if (travelScheduleService.createSchedule(travelScheduleDTO)) {
            TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper("Successfully created travel schedule", null);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            TravelScheduleResponseWrapper response = new TravelScheduleResponseWrapper("Unable to create travel schedule", null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
