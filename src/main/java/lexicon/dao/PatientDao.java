package lexicon.dao;

import lexicon.model.Patient;

import java.util.List;

public interface PatientDao {

    Patient create(Patient patient);

    Patient findByPersonalNumber(String personalNumber);

    List<Patient> findAll();

}
