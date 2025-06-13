package com.example.volunteer.model;

import jakarta.persistence.*;

@Entity
public class Volunteer {

    @Id
    private Long id;  // Manually assigned

    private String name;
    private String email;
    private String availability;

    public Volunteer() {}  // Required by JPA

    public Volunteer(Long id, String name, String email, String availability) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.availability = availability;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }
}
