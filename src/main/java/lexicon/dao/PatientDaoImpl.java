package lexicon.dao;

import lexicon.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
    private final List<Patient> patients;

    public PatientDaoImpl() {
        patients = new ArrayList<>();
    }

    @Override
    public Patient create(Patient patient) {
        if (patient == null) System.out.println("patient cannot be null");
        if (patients.contains(patient)) {
            System.out.println("Patient already exists");
        } else {
            patients.add(patient);
            return patient;
        }
        return null;
    }

    @Override
    public Patient findByPersonalNumber(String personalNumber) {
        if (personalNumber == null) System.out.println("personalNumber was null");
        for (Patient patient : patients)
            if (patient.getPersonalNumber().equalsIgnoreCase(personalNumber))
                return patient;
        return null;
    }

    @Override
    public List<Patient> findAll() {
        return patients;
    }
}
