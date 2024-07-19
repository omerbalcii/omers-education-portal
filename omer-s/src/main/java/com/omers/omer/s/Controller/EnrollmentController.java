package com.omers.omer.s.Controller;

import com.omers.omer.s.Model.Enrollment;
import com.omers.omer.s.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // //http://localhost:8081/enrollment/getall
    @GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Enrollment>> getAll() {
        try {
            List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
            return ResponseEntity.ok(enrollments);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // //http://localhost:8081/enrollment/get/{id}
    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enrollment> getById(@PathVariable(name = "id") Integer id) {
        try {
            Optional<Enrollment> enrollment = enrollmentService.getById(id);
            return enrollment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/enrollment/getbyuserid/{userId}
    @GetMapping(path = "/getbyuserid/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Enrollment>> getByUserId(@PathVariable(name = "userId") Integer userId) {
        try {
            List<Enrollment> enrollments = enrollmentService.getEnrollmentsByUserId(userId);
            return ResponseEntity.ok(enrollments);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/enrollment/getbycourseid/{courseId}
    @GetMapping(path = "/getbycourseid/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Enrollment>> getByCourseId(@PathVariable(name = "courseId") Integer courseId) {
        try {
            List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
            return ResponseEntity.ok(enrollments);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/enrollment/save
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Enrollment> save(@RequestBody Enrollment enrollment) {
        try {
            Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //http://localhost:8081/enrollment/delete/{id}
    @DeleteMapping(path = "/deletebyid/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(@PathVariable(name = "id") Integer id) {
        try {
            boolean result = enrollmentService.deleteEnrollment(id);
            if (result) {
                return ResponseEntity.ok(id + " id'li kayıt başarı ile silindi");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " id'li kayıt bulunamadı");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(id + " id'li kayıt silinemedi");
        }
    }
}
