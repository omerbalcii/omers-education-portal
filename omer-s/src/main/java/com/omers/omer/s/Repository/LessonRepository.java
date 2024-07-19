package com.omers.omer.s.Repository;

import com.omers.omer.s.Model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LessonRepository extends JpaRepository<Lesson, Integer> {


    List<Lesson> findByCourseId(Integer id);

    @Query ("SELECT l FROM Lesson l WHERE l.name = :name")
    List<Lesson> findByLessonName(String name);
}
