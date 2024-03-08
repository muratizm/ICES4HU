package org.codeer.ICES4HU.DTO;

import java.util.Set;

import org.codeer.ICES4HU.Entity.AcademicPersonnel;
import org.codeer.ICES4HU.Entity.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private String name;
    private Set<AcademicPersonnel> academicPersonnel;
    private Set<Student> students;
    private AcademicPersonnel manager;
}
