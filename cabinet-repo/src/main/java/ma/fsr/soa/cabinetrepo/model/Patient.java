package ma.fsr.soa.cabinetrepo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private LocalDate dateNaissance ;

    @Enumerated(EnumType.STRING)
    private Genre genre ;

    private String telephone ;

    @OneToMany(mappedBy = "patient")
    private List<RendezVous> rendezVous ;

    public Patient( String name, LocalDate dateNaissance, Genre genre, String telephone) {

        this.name = name;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.telephone = telephone;
    }
}
