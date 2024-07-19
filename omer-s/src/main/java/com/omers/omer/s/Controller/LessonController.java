package com.omers.omer.s.Controller;

import com.omers.omer.s.Model.Lesson;
import com.omers.omer.s.Service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    //http://localhost:8081/lesson/getall
    @GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lesson>> getAll() {
        try {
            List<Lesson> lessons = lessonService.getAllLessons();
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/lesson/getbycourseid/{id}
    //findByCourseId
    @GetMapping(path = "/getbycourseid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lesson>> getByCourseId(@PathVariable(name = "id") Integer id) {
        try {
            List<Lesson> lessons = lessonService.getLessonsByCourseId(id);
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/lesson/getbyid/{id}
    @GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lesson> getById(@PathVariable(name = "id") Integer id) {
        try {
            Optional<Lesson> lesson = lessonService.getById(id);
            return lesson.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //findByLessonName

    //http://localhost:8081/lesson/getlessonbyname/{name}
    @GetMapping(path = "/getlessonbyname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lesson>> getLessonByName(@PathVariable(name = "name") String name) {
        try {
            List<Lesson> lessons = lessonService.getLessonsByLessonName(name);
            return ResponseEntity.ok(lessons);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/lesson/save
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lesson> save(@RequestBody Lesson lesson) {
        try {
            Lesson savedLesson = lessonService.saveLesson(lesson);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedLesson);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/lesson/delete/{id}
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        try {
            boolean result = lessonService.deleteLesson(id);
            if (result) {
                return ResponseEntity.ok(id + " id'li ders başarı ile silindi");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id'li ders bulunamadı");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id + " id'li ders silinemedi");
        }
    }
}
