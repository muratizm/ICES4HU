package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class SectionEnrolment {
    @Id
    @SequenceGenerator(name = "uid_sequence", sequenceName = "uid_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "uid_sequence", strategy = GenerationType.SEQUENCE)
    private Integer uid;
    private Integer section_id;
    private Integer student_id;
    private boolean is_enrolled;

    public SectionEnrolment() {
    }

    public SectionEnrolment(Integer uid, Integer section_id, Integer student_id, boolean is_enrolled) {
        this.uid = uid;
        this.section_id = section_id;
        this.student_id = student_id;
        this.is_enrolled = is_enrolled;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public boolean isIs_enrolled() {
        return is_enrolled;
    }

    public void setIs_enrolled(boolean is_enrolled) {
        this.is_enrolled = is_enrolled;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        result = prime * result + ((section_id == null) ? 0 : section_id.hashCode());
        result = prime * result + ((student_id == null) ? 0 : student_id.hashCode());
        result = prime * result + (is_enrolled ? 1231 : 1237);
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
        SectionEnrolment other = (SectionEnrolment) obj;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;

        if (section_id == null) {
            if (other.section_id != null)
                return false;
        } else if (!section_id.equals(other.section_id))
            return false;

        if (student_id == null) {
            if (other.student_id != null)
                return false;
        } else if (!student_id.equals(other.student_id))
            return false;

        if (is_enrolled != other.is_enrolled)
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "SectionEnrolment [uid=" + uid + ", section_id=" + section_id + ", student_id=" + student_id
                + ", is_enrolled=" + is_enrolled + "]";
    }

}
