package org.codeer.ICES4HU.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.codeer.ICES4HU.DTO.SemesterDTO;
import org.codeer.ICES4HU.Entity.Semester;
import org.codeer.ICES4HU.Service.SemesterService;
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
@RequestMapping("/api/v1/semesters")
public class SemesterController {

    private SemesterService semesterService;

    record SemesterRequest(String name, String start_date, String end_date, boolean is_active) {
    }

    public SemesterController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping()
    public List<SemesterDTO> getAllSemesters() {
        return semesterService.getAllSemesters();
    }

    @GetMapping("/{semester_id}")
    public SemesterDTO getSemester(
            @PathVariable("semester_id") Integer semester_id) {
        return semesterService
                .getSemesterDTO(semester_id)
                .orElse(null);
    }

    @PostMapping()
    public void addSemester(@RequestBody SemesterRequest sr) {
        Semester s = new Semester();
        s.setName(sr.name());
        try {
            Date start_date = Date.valueOf(LocalDate.parse(sr.start_date()));
            s.setStart_date(start_date);
            Date end_date = Date.valueOf(LocalDate.parse(sr.end_date()));
            s.setEnd_date(end_date);
        } catch (Exception e) {
            throw e;
        }
        s.setIs_active(sr.is_active());
        semesterService.addSemester(s);
    }

    @PutMapping("/{semester_id}")
    public void updateSemester(
            @PathVariable("semester_id") Integer semester_id,
            @RequestBody SemesterRequest sr) throws Exception {
        Semester s = semesterService
                .getSemesterDTO(semester_id)
                .map(semester -> semesterService.convertDTOtoEntity(semester))
                .orElseThrow(() -> new Exception("Semester with given id does not exist"));
        if (sr.name() != null)
            s.setName(sr.name());
        if (sr.start_date() != null) {
            try {
                LocalDate start_date = LocalDate.parse(sr.start_date());
                s.setStart_date(Date.valueOf(start_date));
            } catch (Exception e) {
                throw e;
            }
        }
        if (sr.end_date() != null)
            try {
                LocalDate end_date = LocalDate.parse(sr.end_date());
                s.setEnd_date(Date.valueOf(end_date));
            } catch (Exception e) {
                throw e;
            }
        s.setIs_active(sr.is_active());
        semesterService.addSemester(s);
    }

    @DeleteMapping("/{semester_id}")
    public void deleteSemester(@PathVariable("semester_id") Integer semester_id) {
        semesterService.deleteSemester(semester_id);
    }
}
