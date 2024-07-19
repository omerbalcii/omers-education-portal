package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Integer> {

    @Query("SELECT c FROM Course c WHERE c.name = :name")
    List<Course> findCourseByName(String name);
}
