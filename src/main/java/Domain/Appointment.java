package Domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {
    private LocalDateTime dateTime;
    private String motivo;
    private Patient patient;
    private String id;

    public Appointment(int counter, Patient patient, String hora, String fecha, String motivo) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}