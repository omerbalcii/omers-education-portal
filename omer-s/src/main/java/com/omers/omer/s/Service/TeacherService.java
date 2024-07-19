package com.omers.omer.s.Service;

import com.omers.omer.s.Model.Teacher;
import com.omers.omer.s.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
    public List<Teacher> getTeachersByTeacherName(String name) {
        return teacherRepository.findByTeacherName(name);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getById(Integer id) {
        return teacherRepository.findById(id);
    }

    public boolean deleteTeacher(Integer id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
