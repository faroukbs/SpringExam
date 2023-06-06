package tn.esprit.faroukboussaid.Services;

import tn.esprit.faroukboussaid.Entities.*;

import java.util.Date;
import java.util.List;

public interface Iservice {
    public Clinique addClinique(Clinique clinique);

    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId);

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);

    public Patient addPatient(Patient patient);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long
                                                                         idClinique, Specialite specialite);

    public int getNbrRendezVousMedecin(Long idMedecin);
    public void retrieveRendezVous();
    public int getRevenuMedecin (Long idMedecin, Date startDate, Date endDate);
}
