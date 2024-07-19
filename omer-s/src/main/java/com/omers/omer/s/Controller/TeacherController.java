package com.omers.omer.s.Controller;

import com.omers.omer.s.Model.Teacher;
import com.omers.omer.s.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //http://localhost:8081/teacher/getall
    @GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Teacher>> getAll() {
        try {
            List<Teacher> teachers = teacherService.getAllTeachers();
            return ResponseEntity.ok(teachers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/teacher/getbyid/{id}
    @GetMapping(path = "/getbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> getById(@PathVariable(name = "id") Integer id) {
        try {
            Optional<Teacher> teacher = teacherService.getById(id);
            return teacher.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //getTeachersByTeacherName
    //http://localhost:8081/teacher/getbyteachername/{name}
    @GetMapping(path = "/getbyteachername/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Teacher>> getTeachersByTeacherName(@PathVariable(name = "name") String name) {
        try {
            List<Teacher> teachers = teacherService.getTeachersByTeacherName(name);
            return ResponseEntity.ok(teachers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //http://localhost:8081/teacher/save
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
        try {
            Teacher savedTeacher = teacherService.saveTeacher(teacher);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/teacher/delete/{id}
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        try {
            boolean result = teacherService.deleteTeacher(id);
            if (result) {
                return ResponseEntity.ok(id + " id'li öğretmen başarı ile silindi");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id'li öğretmen bulunamadı");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id + " id'li öğretmen silinemedi");
        }
    }
}
