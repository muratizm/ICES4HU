package org.codeer.ICES4HU.Service;

import static org.codeer.ICES4HU.AuthenticationUser.Role.MANAGER;
import static org.codeer.ICES4HU.AuthenticationUser.Role.INSTRUCTOR;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.codeer.ICES4HU.Authentication.AuthenticationService;
import org.codeer.ICES4HU.Authentication.RegisterRequest;
import org.codeer.ICES4HU.DTO.AcademicPersonnelDTO;
import org.codeer.ICES4HU.Entity.AcademicPersonnel;
import org.codeer.ICES4HU.Entity.Department;
import org.codeer.ICES4HU.Repository.AcademicPersonnelRepository;
import org.springframework.stereotype.Service;

@Service
public class AcademicPersonnelService {
    private final AuthenticationService authenticationService;
    private final AcademicPersonnelRepository repository;
    private final DepartmentService departmentService;

    public AcademicPersonnelService(AuthenticationService authenticationService, AcademicPersonnelRepository repository,
            DepartmentService departmentService) {
        this.authenticationService = authenticationService;
        this.repository = repository;
        this.departmentService = departmentService;
    }

    public AcademicPersonnelDTO convertEntityToDTO(AcademicPersonnel ap) {
        AcademicPersonnelDTO apDto = new AcademicPersonnelDTO();
        apDto.setDepartment(ap.getDepartment());
        apDto.setManagerOf(ap.getManagerOf());
        apDto.setName(ap.getName());
        apDto.setSurname(ap.getSurname());
        apDto.setUsername(ap.getUsername());
        apDto.setEmail(ap.getEmail());
        apDto.setProfilePictureUrl(ap.getProfilePictureUrl());
        return apDto;
    }

    public AcademicPersonnel convertDTOtoEntity(AcademicPersonnelDTO apDto) {
        AcademicPersonnel ap = new AcademicPersonnel();
        ap.setDepartment(apDto.getDepartment());
        ap.setManagerOf(apDto.getManagerOf());
        ap.setName(apDto.getName());
        ap.setSurname(apDto.getSurname());
        ap.setUsername(apDto.getUsername());
        ap.setEmail(apDto.getEmail());
        ap.setProfilePictureUrl(apDto.getProfilePictureUrl());
        return ap;
    }

    public List<AcademicPersonnelDTO> getAllAcademicPersonnel() {
        return repository
                .findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AcademicPersonnelDTO> getAcademicPersonnelDTO(Integer academicPersonnelId) {
        return getAcademicPersonnelEntity(academicPersonnelId)
                .map(this::convertEntityToDTO);
    }

    public Optional<AcademicPersonnel> getAcademicPersonnelEntity(Integer academicPersonnelId) {
        return repository.findById(academicPersonnelId);
    }

    public Integer updateAcademicPersonnel(AcademicPersonnel ap) {
        AcademicPersonnel updatedAP = repository.save(ap);
        return updatedAP.getPersonnelId();
    }

    public Integer addAcademicPersonnel(AcademicPersonnel ap, String password) {
        // Save academic personnel to the academicPersonnel table
        AcademicPersonnel savedAP = repository.save(ap);
        Integer savedAPid = savedAP.getPersonnelId();
        // Create records in auth_user and auth_token tables
        var role = ap.getManagerOf() == null ? INSTRUCTOR : MANAGER;
        var authRecord = RegisterRequest.builder()
                .name(ap.getName())
                .surname(ap.getSurname())
                .username(ap.getUsername())
                .password(password)
                .studentId(null)
                .personnelId(savedAPid)
                .role(role)
                .build();
        authenticationService.register(authRecord);
        return savedAPid;
    }

    public void deleteAcademicPersonnel(Integer academicPersonnelId) {
        repository.deleteById(academicPersonnelId);
    }

    public void addDepartmentToAcademicPersonnel(Integer departmentId, Integer personnelId) throws Exception {
        if (departmentId == null || personnelId == null)
            return;
        AcademicPersonnel ap = this
                .getAcademicPersonnelEntity(personnelId)
                .orElseThrow(() -> new Exception("Academic personnel with given id does not exist"));
        Department d = departmentService
                .getDepartmentEntity(departmentId)
                .orElseThrow(() -> new Exception("Department with given id does not exist"));
        ap.setDepartment(d);
        repository.save(ap);

        departmentService.addAcademicPersonnelToDepartment(ap, departmentId);
    }

    public void addManagedDepartmentToAcademicPersonnel(Integer departmentId, Integer personnelId) throws Exception {
        if (departmentId == null || personnelId == null)
            return;
        AcademicPersonnel ap = this
                .getAcademicPersonnelEntity(personnelId)
                .orElseThrow(() -> new Exception("Academic personnel with given id does not exist"));
        Department d = departmentService
                .getDepartmentEntity(departmentId)
                .orElseThrow(() -> new Exception("Department with given id does not exist"));
        ap.setManagerOf(d);
        repository.save(ap);
    }
}
