package ma.fsr.soa.patientserviceapi;


import ma.fsr.soa.cabinetrepo.model.Patient;
import ma.fsr.soa.cabinetrepo.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {
    PatientRepo patientRepo;
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Patient getPatientById(Long id){
        return patientRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Patient introuvable : id ="+id));
    }

    public List<Patient> searchPatientByNom(String nom){
        return patientRepo.findByName(nom);
    }


    public Patient createPatient(Patient patient) throws Exception {
        if (patient.getName()==null || patient.getName().isBlank()) {
            throw new IllegalAccessException("Nom obligatoire") ;
        }
        if (patient.getGenre()==null) {
            throw new IllegalArgumentException("Genre obligatoire") ;
        }
        if (patient.getDateNaissance()==null) {
            throw new IllegalArgumentException("la date de naissance est obligatoire") ;
        }
        if (patient.getDateNaissance().isAfter(LocalDate.now()))
            throw new IllegalArgumentException("La date de naissance ne peut pas être future ") ;
        return patientRepo.save(patient);
    }

    public Patient updatePatient(Patient patient) throws Exception {
        if (patient.getName()==null || patient.getName().isBlank()) {
            throw new IllegalAccessException("Nom obligatoire") ;
        }
        if (patient.getGenre()==null) {
            throw new IllegalAccessException("Genre obligatoire") ;
        }
        if (patient.getDateNaissance()==null) {
            throw new IllegalAccessException("la date de naissance est obligatoire") ;
        }
        return patientRepo.save(patient);
    }
    public void deletePatient(Patient patient) throws IllegalAccessException {
        if (!patientRepo.existsById(patient.getId())) {
            throw new IllegalAccessException("Le patient n'existe pas") ;
        }
         patientRepo.delete(patient);
    }

}
