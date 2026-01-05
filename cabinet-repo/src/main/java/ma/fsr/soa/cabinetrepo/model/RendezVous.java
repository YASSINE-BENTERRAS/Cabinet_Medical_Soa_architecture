package ma.fsr.soa.cabinetrepo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private LocalDate dateRdv ;
    private Statu statu;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore

    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    @JsonIgnore

    private Medecin medecin;

    public RendezVous(LocalDate dateRdv, Statu statu, Patient patient, Medecin medecin) {
        this.dateRdv = dateRdv;
        this.statu = statu;
        this.patient = patient;
        this.medecin = medecin;
    }
}
