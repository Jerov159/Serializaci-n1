package Interfaces;

import Domain.Appointment;

import java.util.List;

public interface AppointmentRepo {
    List<Appointment> findAll();
    Appointment findByid(int id);
    void save(Appointment appointment);
    void update(Appointment appointment);
    void delete(int id);
}