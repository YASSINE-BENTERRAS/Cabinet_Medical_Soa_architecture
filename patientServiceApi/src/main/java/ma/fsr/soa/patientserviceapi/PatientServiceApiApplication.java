package ma.fsr.soa.patientserviceapi;

import ma.fsr.soa.cabinetrepo.model.*;
import ma.fsr.soa.cabinetrepo.repository.ConsultationRepo;
import ma.fsr.soa.cabinetrepo.repository.MedecinRepo;
import ma.fsr.soa.cabinetrepo.repository.PatientRepo;
import ma.fsr.soa.cabinetrepo.repository.RendezVousRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ma.fsr.soa.cabinetrepo.repository")
@EntityScan(basePackages = "ma.fsr.soa.cabinetrepo.model")
public class PatientServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApiApplication.class, args);
    }
    @Bean
    CommandLineRunner initDB(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo, ConsultationRepo consultationRepo)
        {
            Patient patient1 = new Patient(
                    "Hicham",
                    LocalDate.of(2002, 12, 1),
                    Genre.Homme,

                    "+212987453423"
            );

            Patient patient2 = new Patient(
                    "Ilyas",
                    LocalDate.of(2006, 12, 1),
                    Genre.Homme,
                    "+212567453423"
            );

            Patient patient3 = new Patient(
                    "Hiba",
                    LocalDate.of(2000, 9, 1),
                    Genre.Femme,
                    "+212564563423"
            );
            Patient patient5 = new Patient(
                    "Manal",
                    LocalDate.of(2000, 9, 1),
                    Genre.Femme,
                    "+212564563423"
            );

            Patient patient4 = new Patient(
                    "Arwa",
                    LocalDate.of(2016, 6, 2),
                    Genre.Femme,
                    "+212569876543"
            );

            Medecin medecin1 = new Medecin(
                    "Karim",
                    "Cardiologie",
                    "karim@gmail.com"
            ) ;

            Medecin medecin2 = new Medecin(
                    "Ilyas",
                    "generaliste",
                    "ilyas@gmail.com"
            ) ;

            RendezVous rendezVousX = new RendezVous( LocalDate.of(2026,12,18),
                    Statu.PLANIFIE,
                    patient3,
                    medecin1) ;

            Consultation consultation1 = new Consultation(LocalDate.of(2026,12,31),
                    "Consultation cardiologique de suivi. État clinique stable, pas de signes alarmants. Traitement maintenu et suivi recommandé.",
                    rendezVousX
            );

            return args -> {
                // Patients
                patientRepo.save(new Patient(
                        "Yassine",
                        LocalDate.of(2004, 10, 1),
                        Genre.Homme,
                        "+212567453423"
                ));
                patientRepo.save(patient1);
                patientRepo.save(patient2);
                patientRepo.save(patient3);
                patientRepo.save(patient4);


                // Médecins
                medecinRepo.save(medecin1);
                medecinRepo.save(medecin2);

                medecinRepo.save(new Medecin(
                        "Reda",
                        "Cardiologie",
                        "reda@gmail.com"
                ));

                rendezVousRepo.save(new RendezVous( LocalDate.of(2026,4,18),
                        Statu.PLANIFIE,
                        patient1,
                        medecin1)) ;
                rendezVousRepo.save(new RendezVous( LocalDate.of(2026,5,18),
                        Statu.PLANIFIE,
                        patient2,
                        medecin1)) ;

                rendezVousRepo.save(new RendezVous( LocalDate.of(2026,6,18),
                        Statu.PLANIFIE,
                        patient3,
                        medecin2)) ;

                rendezVousRepo.save(new RendezVous( LocalDate.of(2026,12,18),
                        Statu.PLANIFIE,
                        patient4,
                        medecin2)) ;
                rendezVousRepo.save(rendezVousX);

                consultationRepo.save(consultation1);
            };
        }
    }
