package ma.fsr.soa.consultationserviceapi;


import ma.fsr.soa.cabinetrepo.model.Consultation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {
    private final ConsultationService consultationService;
    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public Consultation addConsultation(@RequestBody ConsultationRequestDto requestDto){
        return consultationService.createConsultation(requestDto);
    }

    @GetMapping
    public List<Consultation> getAll(){
        return consultationService.getAll() ;
    }

    @GetMapping("/{id}")
    public Consultation getConsultationById(@PathVariable Long id){
        return consultationService.searchById(id);
    }
}