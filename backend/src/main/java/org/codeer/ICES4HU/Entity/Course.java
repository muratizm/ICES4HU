package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "courseIdSequence", sequenceName = "courseIdSequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "courseIdSequence", strategy = GenerationType.SEQUENCE)
    private Integer courseId;
    private Integer instructorId;
    private Integer departmentId;
    private String name;
    private Integer credits;

    public Course() {
    }

    public Course(Integer courseId, Integer instructorId, Integer departmentId, String name, Integer credits) {
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.departmentId = departmentId;
        this.name = name;
        this.credits = credits;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        result = prime * result + ((instructorId == null) ? 0 : instructorId.hashCode());
        result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((credits == null) ? 0 : credits.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (courseId == null) {
            if (other.courseId != null)
                return false;
        } else if (!courseId.equals(other.courseId))
            return false;
        if (instructorId == null) {
            if (other.instructorId != null)
                return false;
        } else if (!instructorId.equals(other.instructorId))
            return false;
        if (departmentId == null) {
            if (other.departmentId != null)
                return false;
        } else if (!departmentId.equals(other.departmentId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (credits == null) {
            if (other.credits != null)
                return false;
        } else if (!credits.equals(other.credits))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Course [courseId=" + courseId + ", instructorId=" + instructorId + ", departmentId=" + departmentId
                + ", name=" + name + ", credits=" + credits + "]";
    }

}
