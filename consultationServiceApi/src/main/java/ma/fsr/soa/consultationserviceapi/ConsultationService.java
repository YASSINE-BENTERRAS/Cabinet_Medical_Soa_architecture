package ma.fsr.soa.consultationserviceapi;

import ma.fsr.soa.cabinetrepo.model.Consultation;
import ma.fsr.soa.cabinetrepo.model.Medecin;
import ma.fsr.soa.cabinetrepo.model.Patient;
import ma.fsr.soa.cabinetrepo.model.RendezVous;
import ma.fsr.soa.cabinetrepo.repository.ConsultationRepo;
import ma.fsr.soa.cabinetrepo.repository.MedecinRepo;
import ma.fsr.soa.cabinetrepo.repository.PatientRepo;
import ma.fsr.soa.cabinetrepo.repository.RendezVousRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConsultationService {
    private final ConsultationRepo consultationRepo ;
    private  final PatientRepo patientRepo ;
    private final MedecinRepo medecinRepo ;
    private final RendezVousRepo rendezVousRepo ;

    public ConsultationService(ConsultationRepo consultationRepo, PatientRepo patientRepo, MedecinRepo medecinRepo , RendezVousRepo rendezVousRepo) {
        this.consultationRepo = consultationRepo;
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
    }

    public Consultation createConsultation(ConsultationRequestDto requestDto){
        Patient patient = patientRepo.findById(requestDto.patientId()).orElseThrow(null);
        Medecin medecin = medecinRepo.findById(requestDto.medecinId()).orElseThrow(null);
        RendezVous rendezVous = rendezVousRepo.findRendezVousByPatientAndMedecin(patient,medecin) ;

        return consultationRepo.save(new Consultation(
                requestDto.dateConsultation(),
                requestDto.report(),
                rendezVous)) ;
    }

    public Consultation searchById(Long id){
        return consultationRepo.findById(id).orElseThrow(null);
    }

    public List<Consultation> getAll(){
        return consultationRepo.findAll();
    }




}