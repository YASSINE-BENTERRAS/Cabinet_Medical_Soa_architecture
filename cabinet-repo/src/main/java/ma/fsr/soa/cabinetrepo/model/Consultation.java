package ma.fsr.soa.cabinetrepo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private LocalDate dateConsultation;
    private String rapport ;

    @OneToOne
    @JoinColumn(name = "RendezVous_id")
    private RendezVous rendezVous ;

    public Consultation(LocalDate localDate, String report, RendezVous rendezVous) {
    }
}
