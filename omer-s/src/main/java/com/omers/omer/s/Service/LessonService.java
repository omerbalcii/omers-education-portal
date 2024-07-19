package com.omers.omer.s.Service;

import com.omers.omer.s.Model.Lesson;
import com.omers.omer.s.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public List<Lesson> getLessonsByCourseId(Integer id) {
        return lessonRepository.findByCourseId(id);
    }

    public List<Lesson> getLessonsByLessonName(String name) {
        return lessonRepository.findByLessonName(name);
    }

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Optional<Lesson> getById(Integer id) {
        return lessonRepository.findById(id);
    }

    public boolean deleteLesson(Integer id) {
        if (lessonRepository.existsById(id)) {
            lessonRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
