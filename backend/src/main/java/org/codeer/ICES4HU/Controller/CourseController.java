package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.Course;
import org.codeer.ICES4HU.Repository.CourseRepository;
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
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseRepository courseRepository;

    record CourseRequest(Integer instructorId, Integer departmentId, String name, Integer credits) {

    }

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping()
    public void addCourse(@RequestBody CourseRequest courseRequest) {
        Course c = new Course();
        c.setDepartmentId(courseRequest.departmentId());
        c.setInstructorId(courseRequest.instructorId());
        c.setName(courseRequest.name());
        c.setCredits(courseRequest.credits());
        courseRepository.save(c);
    }

    @PutMapping("/{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Integer courseId,
            @RequestBody CourseRequest cr) {
        Course c = courseRepository.findById(courseId).orElseGet(() -> new Course());
        if (cr.departmentId() != null)
            c.setDepartmentId(cr.departmentId());
        if (cr.instructorId() != null)
            c.setInstructorId(cr.instructorId);
        if (cr.name() != null)
            c.setName(cr.name());
        if (cr.credits() != null)
            c.setCredits(cr.credits());
        courseRepository.save(c);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
