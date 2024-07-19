package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t WHERE t.name = :name")
    List<Teacher> findByTeacherName(String name);
}
