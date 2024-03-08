package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Section {
    @Id
    @SequenceGenerator(name = "section_id_sequence", sequenceName = "section_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "section_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer section_id;
    private Integer course_id;
    private Integer instructor_id;
    private Integer semester_id;
    private Integer section_no;

    public Section() {
    }

    public Section(Integer section_id, Integer course_id, Integer instructor_id, Integer semester_id,
            Integer section_no) {
        this.section_id = section_id;
        this.course_id = course_id;
        this.instructor_id = instructor_id;
        this.semester_id = semester_id;
        this.section_no = section_no;
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Integer instructor_id) {
        this.instructor_id = instructor_id;
    }

    public Integer getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Integer semester_id) {
        this.semester_id = semester_id;
    }

    public Integer getSection_no() {
        return section_no;
    }

    public void setSection_no(Integer section_no) {
        this.section_no = section_no;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((section_id == null) ? 0 : section_id.hashCode());
        result = prime * result + ((course_id == null) ? 0 : course_id.hashCode());
        result = prime * result + ((instructor_id == null) ? 0 : instructor_id.hashCode());
        result = prime * result + ((semester_id == null) ? 0 : semester_id.hashCode());
        result = prime * result + ((section_no == null) ? 0 : section_no.hashCode());
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
        Section other = (Section) obj;
        if (section_id == null) {
            if (other.section_id != null)
                return false;
        } else if (!section_id.equals(other.section_id))
            return false;
        if (course_id == null) {
            if (other.course_id != null)
                return false;
        } else if (!course_id.equals(other.course_id))
            return false;
        if (instructor_id == null) {
            if (other.instructor_id != null)
                return false;
        } else if (!instructor_id.equals(other.instructor_id))
            return false;
        if (semester_id == null) {
            if (other.semester_id != null)
                return false;
        } else if (!semester_id.equals(other.semester_id))
            return false;
        if (section_no == null) {
            if (other.section_no != null)
                return false;
        } else if (!section_no.equals(other.section_no))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Section [section_id=" + section_id + ", course_id=" + course_id + ", instructor_id=" + instructor_id
                + ", semester_id=" + semester_id + ", section_no=" + section_no + "]";
    }

}
