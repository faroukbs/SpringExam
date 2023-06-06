package tn.esprit.faroukboussaid.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Medecin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedcin ;
    String nomMedcin;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    int telephone;
    int prixConsultation;

    @ManyToMany(mappedBy = "medcins",cascade = CascadeType.PERSIST)
    Set<Clinique> cliniques;
    @OneToMany(mappedBy = "medcin",cascade = CascadeType.PERSIST )
    Set<RendezVous>rendezVous;

}
