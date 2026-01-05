package ma.fsr.soa.cabinetrepo.repository;


import ma.fsr.soa.cabinetrepo.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
}
