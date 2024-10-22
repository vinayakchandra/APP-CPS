package dev.vinayak.appcps.controller;

import dev.vinayak.appcps.entity.Student;
import dev.vinayak.appcps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student postDetails(@RequestBody Student student) {
        System.out.println(student);
        return studentService.saveDetails(student);
    }

    @GetMapping("/getAll")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/getStudent/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
