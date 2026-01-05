package ma.fsr.soa.consultationserviceapi;


import java.time.LocalDate;

public record ConsultationRequestDto(Long patientId ,
                                     Long medecinId ,
                                     LocalDate dateConsultation ,
                                     String report
) {
}