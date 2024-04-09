package Interfaces;

import Domain.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findByid(int id);
    void save (Patient patient);
    void update(Patient patient);
    void delete (int id);
}
