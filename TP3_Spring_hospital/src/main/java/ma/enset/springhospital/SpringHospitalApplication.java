package ma.enset.springhospital;

import ma.enset.springhospital.entities.Patient;
import ma.enset.springhospital.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringHospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            /*patientRepository.save(new Patient().builder().id(null).name("Scott").birthday(new Date()).isSick(false).score(345).build());
            patientRepository.save(new Patient().builder().id(null).name("Beesly").birthday(new Date()).isSick(false).score(345).build());
            patientRepository.save(new Patient().builder().id(null).name("Halpert").birthday(new Date()).isSick(false).score(345).build());*/
            //patientRepository.save(new Patient(null, "Scott", new Date(), false, 345));
            Stream.of("saad", "youssef", "amine")
                    .forEach(name->{
                        Patient patient= Patient.builder()
                                .name(name)
                                .birthday(new Date())
                                .sick(false)
                                .score((int) (100+Math.random()*100))
                                .build();
                        patientRepository.save(patient);

                    });

        };
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
