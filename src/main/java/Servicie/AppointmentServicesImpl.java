package Servicie;


import Domain.Appointment;
import Domain.Patient;
import Interfaces.AppointmentRepo;
import Interfaces.AppointmentService;
import Interfaces.PatientRepo;

import java.util.List;

public class AppointmentServicesImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;

    public AppointmentServicesImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment findByid(int id) {
        return appointmentRepo.findByid(id);
    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepo.save (appointment);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentRepo.update(appointment);
    }

    @Override
    public void delete(int id) {
        appointmentRepo.delete(id);
    }
}
