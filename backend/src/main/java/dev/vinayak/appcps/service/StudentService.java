package dev.vinayak.appcps.service;

import dev.vinayak.appcps.entity.Student;
import dev.vinayak.appcps.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepo;

    public Student saveDetails(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void deleteStudent(Integer studentId) {
        studentRepo.deleteById(studentId);
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    public Student updateStudent(int id, Student student) {
        Optional<Student> existingStudent = studentRepo.findById(id);
        if (existingStudent.isPresent()) {
            student.setId(student.getId());
            student.setName(student.getName());
            student.setRa_number(student.getRa_number());
            student.setDept(student.getDept());
            return studentRepo.save(student);
        } else {
            throw new IllegalArgumentException("Student not found with id: ");
        }
    }
}
