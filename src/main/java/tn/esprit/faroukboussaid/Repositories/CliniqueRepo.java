package tn.esprit.faroukboussaid.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.faroukboussaid.Entities.Clinique;

@Repository
public interface CliniqueRepo extends JpaRepository<Clinique,Long> {

}
