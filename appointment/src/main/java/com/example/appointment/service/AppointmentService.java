package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    // CREATE / UPDATE
    public Appointment saveAppointment(Appointment appointment) {
        return repository.save(appointment);
    }

    // READ ALL
    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    // READ BY ID
    public Appointment getAppointmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
    }

    // DELETE
    public void deleteAppointment(Long id) {
        repository.deleteById(id);
    }
}

