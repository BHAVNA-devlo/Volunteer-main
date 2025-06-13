package com.example.volunteer.repository;

import com.example.volunteer.model.Volunteer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    // ✅ Delete all volunteers with any null fields
    @Modifying
    @Transactional
    @Query("DELETE FROM Volunteer v WHERE v.name IS NULL OR v.email IS NULL OR v.availability IS NULL")
    void deleteVolunteersWithNullFields();

    // ✅ Optional: find available volunteers
    java.util.List<Volunteer> findByAvailability(String availability);
}
