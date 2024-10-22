package dev.vinayak.appcps.repository;

import dev.vinayak.appcps.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
