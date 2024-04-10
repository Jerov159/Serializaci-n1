package Domain;

import InfraestructuraRepository.AppointmentRepoIMPL;
import InfraestructuraRepository.PatientRepoIMPL;
import Interfaces.AppointmentRepo;
import Interfaces.AppointmentService;
import Interfaces.PatientRepo;
import Interfaces.PatientService;
import Servicie.AppointmentServicesImpl;
import Servicie.PatientServicesImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final AppointmentService appoinmentService;
    private static final PatientService patientService;

    static {

        PatientRepo patientRepo = new PatientRepoIMPL();
        patientService = new PatientServicesImpl(patientRepo);

        AppointmentRepo appointmentRepo = new AppointmentRepoIMPL();
        appoinmentService = new AppointmentServicesImpl(appointmentRepo);

    }

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Register Patient");
            System.out.println("2.  update data");
            System.out.println("3. register existing patient appointment");
            System.out.println("4. delete appointment");
            System.out.println("5. show patients");
            System.out.println("6. show patient appointments");
            System.out.println("7. Back");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerPatient(); //listo
                    break;
                case 2:
                    //Actualizar datos
                    actualizarPaciente(); //listo
                    break;
                case 3:
                    //registrar cita paciente existente
                    registrarCita(); //listo
                    break;
                case 4:
                    //eliminar cita
                    eliminarCita(); //listo
                    break;
                case 5:
                    listarPacientes(); //listo
                    //mostrar pacientes
                    break;
                case 6:
                    listarCitas(); //listo
                    //Mostrar citas del paciente
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private static void registerPatient() {

        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter the patient's name: ");
        String namePatient = scanner.nextLine();
        System.out.print("Enter the patient's last name: ");
        String lastnamePatient = scanner.nextLine();
        System.out.print("Enter patient's age: ");
        short age = scanner.nextShort();
        System.out.print("Enter the patient's gender: ");
        String genre = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Ingrese la direccion del paciente: ");
        String address = scanner.nextLine();
        System.out.print("Ingrese el telefono del paciente: ");
        String phone = scanner.nextLine();

        Patient pacientes = new Patient(id, namePatient, lastnamePatient, age, genre, address, phone);

        try {
            patientService.save(pacientes);
            System.out.println("Producto creado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void actualizarPaciente() {
        System.out.print("Ingrese el cc del paciente a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Patient patients = patientService.findByid(id);
        if (patients == null) {
            System.out.println("No se encontró el paciente con cc " + id);
            return;
        }

        System.out.print("Ingrese el nuevo nombre del paciente (dejar en blanco para no cambiar): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            patients.setName(name);
        }
        System.out.print("Ingrese el nuevo apellido del paciente (dejar en blanco para no cambiar): ");
        String lastname = scanner.nextLine();
        if (!lastname.isEmpty()) {
            patients.setLastname(lastname);
        }

        System.out.print("Ingrese el genero del paciente (dejar en blanco para no cambiar): ");
        String genre = scanner.nextLine();
        if (!genre.isEmpty()) {
            patients.setGenre(genre);
        }

        System.out.print("Ingrese la nueva direccion del paciente (dejar en blanco para no cambiar): ");
        String address = scanner.nextLine();
        if (!address.isEmpty()) {
            patients.setAddress(address);
        }

        System.out.print("Ingrese el nuevo numero de telefono del paciente (dejar en blanco para no cambiar): ");
        String phone = scanner.nextLine();
        if (!phone.isEmpty()) {
            patients.setPhone(phone);
        }

        try {
            patientService.update(patients);
            System.out.println("Paciente actualizado exitosamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registrarCita() {

        List<Appointment> appointmentList = appoinmentService.findAll();
        int counter = appointmentList.size() + 1;

        System.out.print("Ingrese la identificacion del paciente para crear la cita: ");
        String id = scanner.nextLine();
        Patient patient = patientService.findByid(Integer.parseInt(id));
        if (patient == null) {
            System.out.println("No existe el usuario, debe estar registrado para crear la cita");
        } else {
            System.out.println("Ususario encontrado");
            System.out.println("Imgrese Hora de la cita");
            String hora = scanner.nextLine();
            System.out.println("Imgrese la fecha de la cita");
            String fecha = scanner.nextLine();
            System.out.println("Imgrese motivo de la cita");
            String motivo = scanner.nextLine();
            appoinmentService.save(new Appointment(counter, patient, hora, fecha, motivo));
            System.out.println("Registrado con exito");
        }
    }

    private static void eliminarCita() {
        System.out.print("Ingrese el ID de la cita a eliminar: ");
        int id = scanner.nextInt();

        Appointment appointments = appoinmentService.findByid(id);
        if (appointments == null) {
            System.out.println("No se encontró la cita con ID " + id);
            return;
        }

        appoinmentService.delete(id);
        System.out.println("Producto eliminado exitosamente.");
    }

    private static void listarCitas() {

        List<Appointment> appointments = appoinmentService.findAll();
        System.out.println("Identificacion del paciente: ");
        String id = scanner.nextLine();

        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getId().equals(id)) {
                System.out.println(appointment);
            }
        }
    }

    private static void listarPacientes() {

        List<Patient> pacientes = patientService.findAll();
        if (pacientes.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            System.out.println("Patient List:");
            for (Patient patient : pacientes) {
                System.out.println(patient);
            }
        }
    }

}
