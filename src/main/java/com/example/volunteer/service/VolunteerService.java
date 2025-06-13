package com.example.volunteer.service;

import com.example.volunteer.model.Volunteer;
import java.util.List;

public interface VolunteerService {
    List<Volunteer> getAll();
    Volunteer getById(Long id);
    Volunteer save(Volunteer volunteer);
    Volunteer update(Long id, Volunteer volunteer);
    void delete(Long id);
    List<Volunteer> getAvailableVolunteers();
    void deleteNullVolunteers();
}
