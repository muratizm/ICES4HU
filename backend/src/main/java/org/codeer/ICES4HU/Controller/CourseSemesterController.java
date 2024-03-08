package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.CourseSemester;
import org.codeer.ICES4HU.Repository.CourseSemesterRepository;
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
@RequestMapping("/api/v1/courseSemesters")
public class CourseSemesterController {

    private CourseSemesterRepository courseSemesterRepository;

    record CourseSemesterRequest(Integer course_id, Integer semester_id) {
    }

    public CourseSemesterController(CourseSemesterRepository courseSemesterRepository) {
        this.courseSemesterRepository = courseSemesterRepository;
    }

    @GetMapping()
    public List<CourseSemester> getAllCourseSemesters() {
        return courseSemesterRepository.findAll();
    }

    @PostMapping()
    public void addCourseSemester(@RequestBody CourseSemesterRequest courseSemesterRequest) {
        CourseSemester cs = new CourseSemester();
        cs.setCourse_id(courseSemesterRequest.course_id());
        cs.setSemester_id(courseSemesterRequest.semester_id());
        courseSemesterRepository.save(cs);
    }

    @PutMapping("/{uid}")
    public void updateCourseSemester(
            @PathVariable("uid") Integer uid,
            @RequestBody CourseSemesterRequest csr) {
        CourseSemester cs = courseSemesterRepository.findById(uid).orElseGet(() -> new CourseSemester());
        if (csr.course_id() != null)
            cs.setCourse_id(csr.course_id());
        if (csr.semester_id() != null)
            cs.setSemester_id(csr.semester_id());

        courseSemesterRepository.save(cs);
    }

    @DeleteMapping("/{uid}")
    public void deleteCourseSemester(@PathVariable("uid") Integer uid) {
        courseSemesterRepository.deleteById(uid);
    }
}
