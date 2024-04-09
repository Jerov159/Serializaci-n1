package InfraestructuraRepository;

import Domain.Appointment;
import Interfaces.AppointmentRepo;
import Interfaces.AppointmentService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentRepoIMPL implements AppointmentService, AppointmentRepo {

    private static final String FILE_NAME = "appointment.dat";

    @Override
    public List<Appointment> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Appointment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Appointment findByid(int id) {
        return findAll().stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Appointment appointment) {
        List<Appointment> appointments = findAll();
        appointments.add(appointment);
        saveAll(appointments);
    }

    @Override
    public void update(Appointment appointment) {

    }

    @Override
    public void delete(int id) {
        List<Appointment> appointments = findAll();
        appointments = appointments.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
        saveAll(appointments);
    }

    private void saveAll(List<Appointment> citas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(citas);
        } catch (IOException e) {
            e.printStackTrace();


        }
    }
}