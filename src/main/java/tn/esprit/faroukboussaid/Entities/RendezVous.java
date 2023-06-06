package tn.esprit.faroukboussaid.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class RendezVous  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRdv ;
    Date dateRdv;
    String remarque ;
    @ManyToOne()
@JsonIgnore
    Medecin medcin;

    @ManyToOne()
            @JsonIgnore
    Patient patient;
}
