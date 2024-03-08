package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseSemester {
    @Id
    @SequenceGenerator(name = "uid_sequence", sequenceName = "uid_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "uid_sequence", strategy = GenerationType.SEQUENCE)
    private Integer uid;
    private Integer course_id;
    private Integer semester_id;

    public CourseSemester() {
    }

    public CourseSemester(Integer uid, Integer course_id, Integer semester_id) {
        this.uid = uid;
        this.course_id = course_id;
        this.semester_id = semester_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Integer semester_id) {
        this.semester_id = semester_id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        result = prime * result + ((course_id == null) ? 0 : course_id.hashCode());
        result = prime * result + ((semester_id == null) ? 0 : semester_id.hashCode());
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
        CourseSemester other = (CourseSemester) obj;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;
        if (course_id == null) {
            if (other.course_id != null)
                return false;
        } else if (!course_id.equals(other.course_id))
            return false;
        if (semester_id == null) {
            if (other.semester_id != null)
                return false;
        } else if (!semester_id.equals(other.semester_id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CourseSemester [uid=" + uid + ", course_id=" + course_id + ", semester_id=" + semester_id + "]";
    }

}
