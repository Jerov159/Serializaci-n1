package InfraestructuraRepository;

import Domain.Patient;
import Interfaces.PatientRepo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PatientRepoIMPL implements PatientRepo {
    private static final String FILE_NAME = "patients.dat";

    @Override
    public List<Patient> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Patient>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Patient findByid(int id) {
        return findAll().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(Patient patient) {
        List<Patient> patients = findAll();
        patients.add(patient);
        saveAll(patients);
    }

    @Override
    public void update(Patient patient) {
        List<Patient> patients = findAll();
        patients = patients.stream().map(p -> Objects.equals(p.getId(), patient.getId()) ? patient : p)
                .collect(Collectors.toList());
        saveAll(patients);
    }

    @Override
    public void delete(int id) {
        List<Patient> patients = findAll();
        patients = patients.stream()
                .filter(p -> p.getId(id) != id)
                .collect(Collectors.toList());
        saveAll(patients);
    }

    private void saveAll(List<Patient> patients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(patients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}