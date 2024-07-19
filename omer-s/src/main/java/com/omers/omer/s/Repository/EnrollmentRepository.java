package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

    List<Enrollment> findByUserId(Integer userId);

    List<Enrollment> findByCourseId(Integer courseId);
}
