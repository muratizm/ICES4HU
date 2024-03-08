package org.codeer.ICES4HU.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.codeer.ICES4HU.DTO.DepartmentDTO;
import org.codeer.ICES4HU.Entity.AcademicPersonnel;
import org.codeer.ICES4HU.Entity.Department;
import org.codeer.ICES4HU.Entity.Student;
import org.codeer.ICES4HU.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public DepartmentDTO convertEntityToDTO(Department department) {
        if (department == null)
            return null;
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        departmentDTO.setAcademicPersonnel(department.getAcademicPersonnel());
        departmentDTO.setStudents(department.getStudents());
        departmentDTO.setManager(department.getManager());
        return departmentDTO;
    }

    public Department convertDTOtoEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setAcademicPersonnel(departmentDTO.getAcademicPersonnel());
        department.setStudents(departmentDTO.getStudents());
        department.setManager(departmentDTO.getManager());
        return department;
    }

    public List<DepartmentDTO> getAllDepartments() {
        return repository
                .findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> getDepartmentDTO(Integer departmentId) {
        return getDepartmentEntity(departmentId).map(this::convertEntityToDTO);
    }

    public Optional<Department> getDepartmentEntity(Integer departmentId) {
        return repository.findById(departmentId);
    }

    public Integer addDepartment(Department department) {
        Department saved = repository.save(department);
        return saved.getDepartment_id();
    }

    public void deleteDepartment(Integer departmentId) {
        repository.deleteById(departmentId);
    }

    public void addAcademicPersonnelToDepartment(AcademicPersonnel ap, Integer departmentId) throws Exception {
        if (ap == null || departmentId == null)
            return;
        Department d = getDepartmentEntity(departmentId)
                .orElseThrow(() -> new Exception("Department with given id does not exist"));

        d.getAcademicPersonnel().add(ap);
        repository.save(d);
    }

    public void addStudentsToDepartment(Student s, Integer departmentId) throws Exception {
        if (s == null || departmentId == null)
            return;
        Department d = getDepartmentEntity(departmentId)
                .orElseThrow(() -> new Exception("Department with given id does not exist"));

        d.getStudents().add(s);
        repository.save(d);
    }
}
