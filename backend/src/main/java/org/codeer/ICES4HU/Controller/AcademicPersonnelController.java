package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.DTO.AcademicPersonnelDTO;
import org.codeer.ICES4HU.Entity.AcademicPersonnel;
import org.codeer.ICES4HU.Service.AcademicPersonnelService;
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
@RequestMapping("/api/v1/personnel")
public class AcademicPersonnelController {
    private AcademicPersonnelService academicPersonnelService;

    record AcademicPersonnelRequest(
            Integer departmentId, Integer managerOf, String username, String password, String name, String surname,
            String email, String profilePictureUrl) {

    }

    public AcademicPersonnelController(AcademicPersonnelService academicPersonnelService) {
        this.academicPersonnelService = academicPersonnelService;
    }

    @GetMapping()
    public List<AcademicPersonnelDTO> getAllAcademicPersonnel() {
        return academicPersonnelService.getAllAcademicPersonnel();
    }

    @GetMapping("/{academicPersonnelId}")
    public AcademicPersonnelDTO getAcademicPersonnel(@PathVariable("academicPersonnelId") Integer academicPersonnelId)
            throws Exception {
        return academicPersonnelService
                .getAcademicPersonnelDTO(academicPersonnelId)
                .orElseThrow(() -> new Exception("Academic personnel id does not exist."));
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PostMapping
    public void addAcademicPersonnel(@RequestBody AcademicPersonnelRequest apr) throws Exception {
        AcademicPersonnel ap = new AcademicPersonnel();
        ap.setEmail(apr.email());
        ap.setName(apr.name());
        ap.setProfilePictureUrl(apr.profilePictureUrl());
        ap.setSurname(apr.surname());
        ap.setUsername(apr.username());
        Integer personnelId = academicPersonnelService.addAcademicPersonnel(ap, apr.password());

        // Add department to the academicPersonnel if department exists
        if (apr.departmentId() != null)
            academicPersonnelService.addDepartmentToAcademicPersonnel(apr.departmentId(), personnelId);

        // Add department as managed department of the academicPersonnel
        if (apr.managerOf() != null)
            academicPersonnelService.addManagedDepartmentToAcademicPersonnel(apr.departmentId(), personnelId);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PutMapping("/{academicPersonnelId}")
    public void updatePersonnel(
            @PathVariable("academicPersonnelId") Integer academicPersonnelId,
            @RequestBody AcademicPersonnelRequest apr) throws Exception {
        AcademicPersonnel ap = academicPersonnelService
                .getAcademicPersonnelEntity(academicPersonnelId)
                .orElseThrow(() -> new Exception("Academic personnel id does not exist."));
        if (apr.name() != null)
            ap.setName(apr.name);
        Integer personnelId = academicPersonnelService.updateAcademicPersonnel(ap);

        // Add department to the academicPersonnel if departmentId is passed
        if (apr.departmentId() != null)
            academicPersonnelService.addDepartmentToAcademicPersonnel(apr.departmentId(), personnelId);

        // Add department as managed department of the academicPersonnel
        if (apr.managerOf() != null)
            academicPersonnelService.addManagedDepartmentToAcademicPersonnel(apr.managerOf(), personnelId);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @DeleteMapping("/{academicPersonnelId}")
    public void deleteAcademicPersonnel(@PathVariable("academicPersonnelId") Integer academicPersonnelId) {
        academicPersonnelService.deleteAcademicPersonnel(academicPersonnelId);
    }
}