package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.DTO.StudentDTO;
import org.codeer.ICES4HU.Entity.Student;
import org.codeer.ICES4HU.Service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    record StudentRequest(Integer departmentId, String username, String password, String name, String surname,
            String email, String profilePictureUrl, Boolean isBanned) {
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{student_id}")
    public StudentDTO getSemester(
            @PathVariable("student_id") Integer student_id) {
        return studentService
                .getStudentDTO(student_id)
                .orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public void addStudent(@RequestBody StudentRequest sr) throws Exception {
        Student s = new Student();
        s.setUsername(sr.username());
        s.setBanned(sr.isBanned());
        s.setEmail(sr.email());
        s.setName(sr.name());
        s.setProfilePictureUrl(sr.profilePictureUrl());
        s.setSurname(sr.surname());
        Integer studentId = studentService.addStudent(s, sr.password());

        // Add department to student if department exists
        studentService.addDepartmentToStudent(sr.departmentId(), studentId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Integer studentId,
            @RequestBody StudentRequest sr) throws Exception {
        Student s = studentService
                .getStudentDTO(studentId)
                .map(sdto -> studentService.convertDTOtoEntity(sdto))
                .orElseThrow(() -> new Exception("Student with given id does not exist"));
        if (sr.departmentId() != null)
            studentService.addDepartmentToStudent(sr.departmentId(), studentId);
        if (sr.username() != null)
            s.setUsername(sr.username());
        if (sr.email() != null)
            s.setEmail(sr.email());
        if (sr.name() != null)
            s.setName(sr.name());
        if (sr.profilePictureUrl() != null)
            s.setProfilePictureUrl(sr.profilePictureUrl());
        if (sr.surname() != null)
            s.setSurname(sr.surname());
        if (sr.isBanned() != null)
            s.setBanned(sr.isBanned());
        studentService.updateStudent(s);

        // Add department to student if department exists
        studentService.addDepartmentToStudent(sr.departmentId(), studentId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudent(studentId);
    }
}