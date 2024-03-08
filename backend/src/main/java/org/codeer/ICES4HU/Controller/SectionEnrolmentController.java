package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.SectionEnrolment;
import org.codeer.ICES4HU.Repository.SectionEnrolmentRepository;
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
@RequestMapping("/api/v1/sectionenrolments")
public class SectionEnrolmentController {

    private SectionEnrolmentRepository sectionEnrolmentRepository;

    record SectionEnrolmentRequest(Integer section_id, Integer student_id, boolean is_enrolled) {
    }

    public SectionEnrolmentController(SectionEnrolmentRepository sectionEnrolmentRepository) {
        this.sectionEnrolmentRepository = sectionEnrolmentRepository;
    }

    @GetMapping()
    public List<SectionEnrolment> getAllSectionEnrolments() {
        return sectionEnrolmentRepository.findAll();
    }

    @PostMapping()
    public void addSectionEnrolment(@RequestBody SectionEnrolmentRequest ser) {
        SectionEnrolment se = new SectionEnrolment();
        se.setSection_id(ser.section_id());
        se.setStudent_id(ser.student_id());
        se.setIs_enrolled(ser.is_enrolled());
        sectionEnrolmentRepository.save(se);
    }

    @PutMapping("/{uid}")
    public void updateSectionEnrolment(
            @PathVariable("uid") Integer uid,
            @RequestBody SectionEnrolmentRequest ser) {
        SectionEnrolment se = sectionEnrolmentRepository.findById(uid).orElseGet(() -> new SectionEnrolment());
        if (ser.section_id() != null)
            se.setSection_id(ser.section_id());
        if (ser.student_id() != null)
            se.setStudent_id(ser.student_id());
        se.setIs_enrolled(ser.is_enrolled());
        sectionEnrolmentRepository.save(se);
    }

    @DeleteMapping("/{uid}")
    public void deleteSectionEnrolment(@PathVariable("uid") Integer uid) {
        sectionEnrolmentRepository.deleteById(uid);
    }
}
