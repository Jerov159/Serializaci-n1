package Servicie;

import Domain.Patient;
import Interfaces.PatientRepo;
import Interfaces.PatientService;

import java.util.List;

public class PatientServicesImpl implements PatientService {
    private final PatientRepo pacienteRepo;

    public PatientServicesImpl(PatientRepo pacienteRepo) {
        this.pacienteRepo = pacienteRepo;
    }

    @Override
    public List<Patient> findAll() {
        return pacienteRepo.findAll();
    }

    @Override
    public Patient findByid(int id) {
        return pacienteRepo.findByid(id);
    }

    @Override
    public void save(Patient patient) {
        pacienteRepo.save(patient);
    }

    @Override
    public void update(Patient patient) {
        pacienteRepo.update(patient);
    }

    @Override
    public void delete(int id) {
        pacienteRepo.delete(id);
    }
}









