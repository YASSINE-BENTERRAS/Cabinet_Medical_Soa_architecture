package ma.fsr.soa.patientserviceapi;

import ma.fsr.soa.cabinetrepo.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/internal/api/v1/patients")
public class PatientController {
    PatientService  patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

        @GetMapping
        public List<Patient> getAllPatients(){
            return patientService.getAllPatients();
        }

        @GetMapping("/{id}")
        public Patient getPatientsById(@PathVariable Long id){
            return patientService.getPatientById(id) ;
        }

        @GetMapping("/ByName")
            public List<Patient> getPatientsByname(@RequestParam String nom){
                return patientService.searchPatientByNom(nom) ;
        }

        @PostMapping
            public Patient addPatient(@RequestBody Patient patient) throws Exception {
               return patientService.createPatient(patient) ;
        }
        @PutMapping
            public Patient updatePatient(@RequestBody Patient patient) throws Exception {
                return patientService.updatePatient(patient) ;
        }
        @DeleteMapping
            public void deletePatient(@RequestBody Patient patient) throws Exception {
                patientService.deletePatient(patient) ;
        }

    }
