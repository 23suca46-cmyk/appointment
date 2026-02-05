package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
         this.service = service;
    }

    // CREATE
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return service.saveAppointment(appointment);
    }

    // READ ALL
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
         return service.getAppointmentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Appointment updateAppointment(
            @PathVariable Long id,
            @RequestBody Appointment appointment) {

        appointment.setId(id);
        return service.saveAppointment(appointment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
    }
}

