package com.example.volunteer.service;

import com.example.volunteer.model.Volunteer;
import com.example.volunteer.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerRepository repository;

    @Override
    public List<Volunteer> getAll() {
        return repository.findAll();
    }

    @Override
    public Volunteer getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Volunteer save(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    @Override
    public Volunteer update(Long id, Volunteer updated) {
        Optional<Volunteer> optional = repository.findById(id);
        if (optional.isPresent()) {
            Volunteer existing = optional.get();
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setAvailability(updated.getAvailability());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Volunteer> getAvailableVolunteers() {
        return repository.findByAvailability("available");
    }
    @Override
    public void deleteNullVolunteers() {
        repository.deleteVolunteersWithNullFields();
    }
}
    