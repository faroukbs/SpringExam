package tn.esprit.faroukboussaid.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.faroukboussaid.Entities.*;
import tn.esprit.faroukboussaid.Services.Iservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
public class AppController {
    Iservice iservice;

    @PostMapping("addclini")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return iservice.addClinique(clinique);
    }

    @PostMapping("addmed/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long cliniqueId) {
        return iservice.addMedecinAndAssignToClinique(medecin, cliniqueId);
    }

    @PostMapping("addpat")
    public Patient addPatient(@RequestBody Patient patient) {
        return iservice.addPatient(patient);
    }

    @PostMapping("addrdv/{idMedecin}/{idPatient}")
    public void addRDVAndAssignMedAndPatient(@RequestBody RendezVous rdv, @PathVariable Long idMedecin, @PathVariable Long idPatient) {
        iservice.addRDVAndAssignMedAndPatient(rdv, idMedecin, idPatient);
    }

    @GetMapping("red/{idClinique}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @RequestParam("specialite") Specialite specialite) {

        return iservice.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("nbred/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin) {

        return iservice.getNbrRendezVousMedecin(idMedecin);
    }

    @GetMapping("cash/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin(
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate

    ) {
        System.out.println(iservice.getRevenuMedecin(idMedecin,startDate,endDate));
        return iservice.getRevenuMedecin(idMedecin,startDate,endDate);
    }
}
