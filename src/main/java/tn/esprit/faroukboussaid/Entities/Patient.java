package tn.esprit.faroukboussaid.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatient ;
    String nomPatient;
    int telephone;
    Date dateNaissaince;
    @OneToMany(mappedBy = "patient",cascade = CascadeType.PERSIST)
    Set<RendezVous>rendezVous;
}
