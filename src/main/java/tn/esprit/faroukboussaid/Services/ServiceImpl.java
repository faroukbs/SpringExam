package tn.esprit.faroukboussaid.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.faroukboussaid.Entities.*;
import tn.esprit.faroukboussaid.Repositories.CliniqueRepo;
import tn.esprit.faroukboussaid.Repositories.MedcinRepo;
import tn.esprit.faroukboussaid.Repositories.PatientRepo;
import tn.esprit.faroukboussaid.Repositories.RendezVousRepo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class ServiceImpl implements Iservice {
    private CliniqueRepo cliniqueRepo;
    private MedcinRepo medcinRepo;
    private RendezVousRepo rendezVousRepo;
    private PatientRepo patientRepo;


    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAssignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique c = cliniqueRepo.findById(cliniqueId).orElse(null);
        medecin.setCliniques(Collections.singleton(c));
        return medcinRepo.save(medecin);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medecin c = medcinRepo.findById(idMedecin).orElse(null);
        Patient p = patientRepo.findById(idPatient).orElse(null);
        rdv.setMedcin(c);
        rdv.setPatient(p);
        rendezVousRepo.save(rdv);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        List<RendezVous> lrdv = rendezVousRepo.findAll();
        List<RendezVous> l = new ArrayList<>();
        for (RendezVous rdv : lrdv) {
            if (rdv.getMedcin().getSpecialite() == specialite) {
                l.add(rdv);
            }
        }
        return l;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {

        return rendezVousRepo.countByMedcin_IdMedcin(idMedecin);
    }

    @Override
    @Scheduled(fixedDelay = 30000)
    public void retrieveRendezVous() {
        List<RendezVous> lrdv = rendezVousRepo.findAll();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        //  System.out.println( simpleDateFormat.format(date));
        for (RendezVous rdv : lrdv) {
            if (rdv.getDateRdv().compareTo(date) < 0) {

                log.info("la liste des rendezvous " + rdv.getDateRdv() + " Medecin:" + rdv.getMedcin().getNomMedcin() + " Patien: " + rdv.getPatient().getNomPatient());
            }
        }
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        List<RendezVous> lrdv = rendezVousRepo.findByDateRdvBetween(startDate, endDate);
        Medecin m = medcinRepo.findById(idMedecin).orElse(null);
        int cash = 0;
            cash= lrdv.size() * m.getPrixConsultation();


        return cash;
    }
}
