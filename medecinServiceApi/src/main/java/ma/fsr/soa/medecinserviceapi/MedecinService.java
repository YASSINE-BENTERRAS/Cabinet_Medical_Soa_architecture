package ma.fsr.soa.medecinserviceapi;

import jakarta.persistence.EntityNotFoundException;
import ma.fsr.soa.cabinetrepo.model.Medecin;
import ma.fsr.soa.cabinetrepo.repository.MedecinRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {

    private final MedecinRepo medecinRepo;

    public MedecinService(MedecinRepo medecinRepo) {
        this.medecinRepo = medecinRepo;
    }

    public Medecin getMedecinById(Long id) {
        return medecinRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Medecin avec id " + id + " n'existe pas"));
    }


    public List<Medecin> getMedecinsByNom(String nom) {
        return medecinRepo.findByNom(nom);
    }

    public Medecin addMedecin(Medecin medecin){
        return medecinRepo.save(medecin);
    }

    public void deleteMedecin(Medecin medecin){
        medecinRepo.delete(medecin);
    }
}
