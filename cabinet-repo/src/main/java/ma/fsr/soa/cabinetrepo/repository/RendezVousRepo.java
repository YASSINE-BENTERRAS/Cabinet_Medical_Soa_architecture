package ma.fsr.soa.cabinetrepo.repository;

import ma.fsr.soa.cabinetrepo.model.Medecin;
import ma.fsr.soa.cabinetrepo.model.Patient;
import ma.fsr.soa.cabinetrepo.model.RendezVous;
import ma.fsr.soa.cabinetrepo.model.Statu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {

    List<RendezVous> findRendezVousByPatient(Patient patient);
    List<RendezVous> findRendezVousByMedecin(Medecin medecin);
    List<RendezVous> findRendezVousByDateRdv(LocalDate dateRdv);
    List<RendezVous> findRendezVousByStatu(Statu statu);
    RendezVous findRendezVousByPatientAndMedecin(Patient patient, Medecin medecin);

}