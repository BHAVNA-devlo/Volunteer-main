package com.example.volunteer.controller;

import com.example.volunteer.model.Volunteer;
import com.example.volunteer.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService service;

    @GetMapping("/all")
    public List<Volunteer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Volunteer getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Volunteer create(@RequestBody Volunteer volunteer) {
        return service.save(volunteer);
    }

    @PutMapping("/{id}")
    public Volunteer update(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        return service.update(id, volunteer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-null")
    public String deleteNullVolunteers() {
        service.deleteNullVolunteers();
        return "All volunteers with null values deleted.";
    }
}
