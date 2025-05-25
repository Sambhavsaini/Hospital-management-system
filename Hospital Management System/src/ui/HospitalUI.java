package ui;
import dao.PatientDAO;
import model.Patient;

import java.util.Scanner;

public class HospitalUI {
    Scanner scanner = new Scanner(System.in);
    PatientDAO patientDAO = new PatientDAO();

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
}
        }
    }
    private void addPatient() {
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = scanner.nextLine();

        Patient patient = new Patient(id, name, age, gender, diagnosis);
        patientDAO.addPatient(patient);
        System.out.println("Patient added successfully.");
    }

    private void viewPatients() {
        System.out.println("--- Patient List ---");
        for (Patient p : patientDAO.getAllPatients()) {
            System.out.println(p.toCSV());
        }
    }
}