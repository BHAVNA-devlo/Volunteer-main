package com.example.volunteer;

import com.example.volunteer.model.Volunteer;
import com.example.volunteer.repository.VolunteerRepository;
import com.example.volunteer.service.VolunteerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VolunteerRegistrationPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolunteerRegistrationPlatformApplication.class, args);
    }

    @Bean
    CommandLineRunner loadData(VolunteerRepository repository, VolunteerService service) {
        return args -> {
            // Clean up null rows
            service.deleteNullVolunteers();

            // Insert valid volunteers
            repository.save(new Volunteer(101L, "Bhavna Singh", "bhavna@google.com", "available"));
            repository.save(new Volunteer(102L, "Rahul Mehta", "rahul@gmail.com", "unavailable"));
            repository.save(new Volunteer(103L, "Anjali Sharma", "anjali@yahoo.com", "available"));
            repository.save(new Volunteer(104L, "Amit Verma", "amit@hotmail.com", "unavailable"));
            repository.save(new Volunteer(105L, "Sneha Rao", "sneha@outlook.com", "available"));
        };
    }
}
