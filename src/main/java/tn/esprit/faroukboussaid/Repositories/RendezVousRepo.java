package tn.esprit.faroukboussaid.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.faroukboussaid.Entities.RendezVous;

import java.util.Date;
import java.util.List;

@Repository
public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {

    int countByMedcin_IdMedcin(Long a);

    List<RendezVous>findByDateRdvBetween(Date db, Date df);

}
