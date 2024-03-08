package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.Section;
import org.codeer.ICES4HU.Repository.SectionRepository;
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
@RequestMapping("/api/v1/sections")
public class SectionController {

    private SectionRepository sectionRepository;

    record SectionRequest(Integer course_id, Integer instructor_id, Integer semester_id, Integer section_no) {
    }

    public SectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @GetMapping()
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @PostMapping()
    public void addSection(@RequestBody SectionRequest sectionRequest) {
        Section s = new Section();
        s.setCourse_id(sectionRequest.course_id());
        s.setInstructor_id(sectionRequest.instructor_id());
        s.setSemester_id(sectionRequest.semester_id());
        s.setSection_no(sectionRequest.section_no());
        sectionRepository.save(s);
    }

    @PutMapping("/{section_id}")
    public void updateSection(
            @PathVariable("section_id") Integer section_id,
            @RequestBody SectionRequest sr) {
        Section s = sectionRepository.findById(section_id).orElseGet(() -> new Section());
        if (sr.course_id() != null)
            s.setCourse_id(sr.course_id());

        if (sr.instructor_id() != null)
            s.setInstructor_id(sr.instructor_id());

        if (sr.semester_id() != null)
            s.setSemester_id(sr.semester_id());

        if (sr.section_no() != null)
            s.setSection_no(sr.section_no());

        sectionRepository.save(s);
    }

    @DeleteMapping("/{section_id}")
    public void deleteSemester(@PathVariable("section_id") Integer section_id) {
        sectionRepository.deleteById(section_id);
    }
}
