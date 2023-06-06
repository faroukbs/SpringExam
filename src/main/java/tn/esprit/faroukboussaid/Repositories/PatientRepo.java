package tn.esprit.faroukboussaid.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.faroukboussaid.Entities.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {
}
