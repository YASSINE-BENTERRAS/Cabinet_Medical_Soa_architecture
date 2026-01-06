package ma.fsr.soa.medecinserviceapi;


import ma.fsr.soa.cabinetrepo.model.Medecin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/medecins")

public class MedecinController {
    MedecinService medecinService ;
    public MedecinController(MedecinService medecinService){
        this.medecinService = medecinService;
    }

    @GetMapping
    public List<Medecin> getAll(){
        return medecinService.getAll();
    }
    @GetMapping("/{id}")
    public Medecin getMedecinById(@PathVariable Long id) {
        return medecinService.getMedecinById(id);

    }

    @GetMapping("/byName")
    public List<Medecin> getByName(@RequestParam String nom) {
        return medecinService.getMedecinsByNom(nom);
    }

    @PostMapping
    public Medecin addMedecin(@RequestBody Medecin medecin){
        return medecinService.addMedecin(medecin);
    }

    @DeleteMapping
    public void deleteMedecin(@RequestBody Medecin medecin){
        medecinService.deleteMedecin(medecin);
    }


}
