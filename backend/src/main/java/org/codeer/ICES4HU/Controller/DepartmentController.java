package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.DTO.DepartmentDTO;
import org.codeer.ICES4HU.Entity.Department;
import org.codeer.ICES4HU.Service.DepartmentService;
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
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    record DepartmentRequest(String name) {
    }

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{department_id}")
    public DepartmentDTO getDepartment(
            @PathVariable("department_id") Integer department_id) {
        return departmentService
                .getDepartmentDTO(department_id)
                .orElse(null);
    }

    @PostMapping()
    public void addDepartment(@RequestBody DepartmentRequest departmentRequest) {
        Department d = new Department();
        d.setName(departmentRequest.name());
        departmentService.addDepartment(d);
    }

    @PutMapping("/{department_id}")
    public void updateDepartment(
            @PathVariable("department_id") Integer department_id,
            @RequestBody DepartmentRequest dr) throws Exception {
        Department d = departmentService
                .getDepartmentDTO(department_id)
                .map(dep -> departmentService.convertDTOtoEntity(dep))
                .orElseThrow(() -> new Exception("Department with given id does not exist"));
        if (dr.name() != null)
            d.setName(dr.name());
        departmentService.addDepartment(d);
    }

    @DeleteMapping("/{department_id}")
    public void deleteDepartment(@PathVariable("department_id") Integer department_id) {
        departmentService.deleteDepartment(department_id);
    }
}
