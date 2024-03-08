package org.codeer.ICES4HU.Repository;

import org.codeer.ICES4HU.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}