package ma.fsr.soa.rendezvousserviceapi;


import ma.fsr.soa.cabinetrepo.model.RendezVous;
import ma.fsr.soa.cabinetrepo.model.Statu;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/internal/api/v1/rendezvous")

public class RendezVousController {
    RendezVousService  rendezVousService ;
    RendezVousController(RendezVousService rendezVousService){
        this.rendezVousService = rendezVousService;
    }

    @GetMapping
    public List<RendezVous> getAllR(){
        return rendezVousService.getAll();
    }

    @GetMapping("/{id}")
    public List<RendezVous> getRendezVousByMedecin(@PathVariable Long id ){
        return rendezVousService.getRdvByMedecin(id);}

    @GetMapping("/byName")
    public List<RendezVous> getRendezVousByPatient(@PathVariable Long id ){
        return rendezVousService.getRdvByPatient(id);
    }

    @GetMapping("/byDate")
    public List<RendezVous> getRendezVousByDate(@RequestParam LocalDate dateRdv){
        return rendezVousService.getRdvBydate(dateRdv);
    }

    @GetMapping("/ByStatu")
    public List<RendezVous> getRendezVousByStatus(@RequestParam Statu statu){
        return rendezVousService.getRdvByStatu(statu);
    }

    @PostMapping("/rendezvous")
    public RendezVous createRendezVous(@RequestBody RendezVousDTO rdvDto) {
        return rendezVousService.addRendezVous(
                rdvDto.getPatientId(),
                rdvDto.getMedecinId(),
                rdvDto.getDateRdv(),
                rdvDto.getStatu()
        );
    }
}
