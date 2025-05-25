package dao;

import model.Patient;
import util.FileUtil;

import java.io.*;
import java.util.*;

public class PatientDAO {
    private final String filePath = "patients.txt";

    public void addPatient(Patient patient) {
        try (BufferedWriter writer = FileUtil.getWriter(filePath, true)) {
            writer.write(patient.toCSV());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = FileUtil.getReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                patients.add(Patient.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    // update and delete can be added similarly
}