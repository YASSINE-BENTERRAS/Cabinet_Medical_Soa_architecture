package ma.fsr.soa.cabinetrepo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nom ;
    private String specialite ;
    private String email ;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous ;

    public Medecin( String nom, String specialite, String email) {
        this.nom = nom;
        this.specialite = specialite;
        this.email = email;
    }
}
