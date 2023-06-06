package tn.esprit.faroukboussaid.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.faroukboussaid.Entities.Medecin;

@Repository
public interface MedcinRepo extends JpaRepository<Medecin,Long> {

    int countByPrixConsultation (Long idmed);
}
