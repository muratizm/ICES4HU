package org.codeer.ICES4HU.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.codeer.ICES4HU.AuthenticationUser.Role.STUDENT;

import org.codeer.ICES4HU.Authentication.AuthenticationService;
import org.codeer.ICES4HU.Authentication.RegisterRequest;
import org.codeer.ICES4HU.DTO.StudentDTO;
import org.codeer.ICES4HU.Entity.Department;
import org.codeer.ICES4HU.Entity.Student;
import org.codeer.ICES4HU.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final AuthenticationService authenticationService;
    private final StudentRepository repository;
    private final DepartmentService departmentService;

    public StudentService(AuthenticationService authenticationService, StudentRepository studentRepository,
            DepartmentService departmentService) {
        this.authenticationService = authenticationService;
        this.repository = studentRepository;
        this.departmentService = departmentService;
    }

    public StudentDTO convertEntityToDTO(Student s) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(s.getStudentId());
        studentDTO.setDepartment(s.getDepartment());
        studentDTO.setName(s.getName());
        studentDTO.setSurname(s.getSurname());
        studentDTO.setUsername(s.getUsername());
        studentDTO.setEmail(s.getEmail());
        studentDTO.setProfilePictureUrl(s.getProfilePictureUrl());
        return studentDTO;
    }

    public Student convertDTOtoEntity(StudentDTO sdto) {
        Student student = new Student();
        student.setStudentId(sdto.getStudentId());
        student.setDepartment(sdto.getDepartment());
        student.setName(sdto.getName());
        student.setSurname(sdto.getSurname());
        student.setUsername(sdto.getUsername());
        student.setEmail(sdto.getEmail());
        student.setProfilePictureUrl(sdto.getProfilePictureUrl());
        return student;
    }

    public List<StudentDTO> getAllStudents() {
        return repository
                .findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentDTO(Integer studentId) {
        return getStudentEntity(studentId).map(this::convertEntityToDTO);
    }

    public Optional<Student> getStudentEntity(Integer studentId) {
        return repository.findById(studentId);
    }

    public Integer updateStudent(Student s) {
        Student savedStudent = repository.save(s);
        return savedStudent.getStudentId();
    }

    public Integer addStudent(Student s, String password) {
        // Add record to the Student table
        Student savedStudent = repository.save(s);
        Integer savedStudentId = savedStudent.getStudentId();
        // Add record to auth_user and auth_token tables
        var authRecord = RegisterRequest.builder()
                .name(s.getName())
                .surname(s.getSurname())
                .username(s.getUsername())
                .password(password)
                .studentId(savedStudentId)
                .personnelId(null)
                .role(STUDENT)
                .build();
        authenticationService.register(authRecord);
        return savedStudentId;
    }

    public void deleteStudent(Integer student_id) {
        repository.deleteById(student_id);
    }

    public void addDepartmentToStudent(Integer departmentId, Integer studentId) throws Exception {
        if (departmentId == null || studentId == null)
            return;
        Student s = this
                .getStudentEntity(studentId)
                .orElseThrow(() -> new Exception("Student with given id does not exist"));
        Department d = departmentService
                .getDepartmentEntity(departmentId)
                .orElseThrow(() -> new Exception("Department with given id does not exist"));
        s.setDepartment(d);
        repository.save(s);

        departmentService.addStudentsToDepartment(s, departmentId);
    }
}
