package org.codeer.ICES4HU.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Semester {
    @Id
    @SequenceGenerator(name = "semester_id_sequence", sequenceName = "semester_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "semester_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer semester_id;
    private String name;
    private Date start_date;
    private Date end_date;
    private boolean is_active;

    public Semester() {
    }

    public Semester(Integer semester_id, String name, Date start_date, Date end_date, boolean is_active) {
        this.semester_id = semester_id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.is_active = is_active;
    }

    public Integer getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(Integer semester_id) {
        this.semester_id = semester_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((semester_id == null) ? 0 : semester_id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
        result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
        result = prime * result + (is_active ? 1231 : 1237);
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
        Semester other = (Semester) obj;
        if (semester_id == null) {
            if (other.semester_id != null)
                return false;
        } else if (!semester_id.equals(other.semester_id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (start_date == null) {
            if (other.start_date != null)
                return false;
        } else if (!start_date.equals(other.start_date))
            return false;
        if (end_date == null) {
            if (other.end_date != null)
                return false;
        } else if (!end_date.equals(other.end_date))
            return false;
        if (is_active != other.is_active)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Semester [semester_id=" + semester_id + ", name=" + name + ", start_date=" + start_date + ", end_date="
                + end_date + ", is_active=" + is_active + "]";
    }

}
