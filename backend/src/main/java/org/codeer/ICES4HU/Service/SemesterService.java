package org.codeer.ICES4HU.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.codeer.ICES4HU.DTO.SemesterDTO;
import org.codeer.ICES4HU.Entity.Semester;
import org.codeer.ICES4HU.Repository.SemesterRepository;
import org.springframework.stereotype.Service;

@Service
public class SemesterService {
    private final SemesterRepository repository;

    public SemesterService(SemesterRepository repository) {
        this.repository = repository;
    }

    public SemesterDTO convertEntityToDTO(Semester semester) {
        SemesterDTO semesterDTO = new SemesterDTO();
        semesterDTO.setName(semester.getName());
        semesterDTO.setStart_date(semester.getStart_date());
        semesterDTO.setEnd_date(semester.getEnd_date());
        return semesterDTO;
    }

    public Semester convertDTOtoEntity(SemesterDTO semesterDto) {
        Semester semester = new Semester();
        semester.setName(semesterDto.getName());
        semester.setStart_date(semesterDto.getStart_date());
        semester.setEnd_date(semesterDto.getEnd_date());
        return semester;
    }

    public List<SemesterDTO> getAllSemesters() {
        return repository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SemesterDTO> getSemesterDTO(Integer semester_id) {
        return getSemesterEntity(semester_id).map(this::convertEntityToDTO);
    }

    public Optional<Semester> getSemesterEntity(Integer semester_id) {
        return repository.findById(semester_id);
    }

    public Integer addSemester(Semester sem) {
        Semester saved = repository.save(sem);
        return saved.getSemester_id();
    }

    public void deleteSemester(Integer semester_id) {
        repository.deleteById(semester_id);
    }
}
