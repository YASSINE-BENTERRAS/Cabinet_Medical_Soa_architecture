package ma.fsr.soa.rendezvousserviceapi;

import lombok.Data;
import ma.fsr.soa.cabinetrepo.model.Statu;

import java.time.LocalDate;

@Data
public class RendezVousDTO {
    private Long patientId;
    private Long medecinId;
    private LocalDate dateRdv;
    private Statu statu;
}
