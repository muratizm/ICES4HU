package org.codeer.ICES4HU.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Survey {
    @Id
    @SequenceGenerator(name = "survey_id_sequence", sequenceName = "survey_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "survey_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer survey_id;
    private Integer section_id;
    private boolean is_for_course;
    private boolean is_submitted;
    private Integer do_it_later_count;
    private boolean is_reevaluate_request_sent;
    private Date start_date;
    private Date end_date;

    public Survey() {
    }

    public Survey(Integer survey_id, Integer section_id, boolean is_for_course, boolean is_submitted,
            Integer do_it_later_count, boolean is_reevaluate_request_sent, Date start_date, Date end_date) {
        this.survey_id = survey_id;
        this.section_id = section_id;
        this.is_for_course = is_for_course;
        this.is_submitted = is_submitted;
        this.do_it_later_count = do_it_later_count;
        this.is_reevaluate_request_sent = is_reevaluate_request_sent;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public boolean isIs_for_course() {
        return is_for_course;
    }

    public void setIs_for_course(boolean is_for_course) {
        this.is_for_course = is_for_course;
    }

    public boolean isIs_submitted() {
        return is_submitted;
    }

    public void setIs_submitted(boolean is_submitted) {
        this.is_submitted = is_submitted;
    }

    public Integer getDo_it_later_count() {
        return do_it_later_count;
    }

    public void setDo_it_later_count(Integer do_it_later_count) {
        this.do_it_later_count = do_it_later_count;
    }

    public boolean isIs_reevaluate_request_sent() {
        return is_reevaluate_request_sent;
    }

    public void setIs_reevaluate_request_sent(boolean is_reevaluate_request_sent) {
        this.is_reevaluate_request_sent = is_reevaluate_request_sent;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((survey_id == null) ? 0 : survey_id.hashCode());
        result = prime * result + ((section_id == null) ? 0 : section_id.hashCode());
        result = prime * result + (is_for_course ? 1231 : 1237);
        result = prime * result + (is_submitted ? 1231 : 1237);
        result = prime * result + ((do_it_later_count == null) ? 0 : do_it_later_count.hashCode());
        result = prime * result + (is_reevaluate_request_sent ? 1231 : 1237);
        result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
        result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
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
        Survey other = (Survey) obj;
        if (survey_id == null) {
            if (other.survey_id != null)
                return false;
        } else if (!survey_id.equals(other.survey_id))
            return false;

        if (section_id == null) {
            if (other.section_id != null)
                return false;
        } else if (!section_id.equals(other.section_id))
            return false;

        if (is_for_course != other.is_for_course)
            return false;
        if (is_submitted != other.is_submitted)
            return false;
        if (do_it_later_count == null) {
            if (other.do_it_later_count != null)
                return false;
        } else if (!do_it_later_count.equals(other.do_it_later_count))
            return false;
        if (is_reevaluate_request_sent != other.is_reevaluate_request_sent)
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

        return true;

    }

    @Override
    public String toString() {
        return "Survey [survey_id=" + survey_id + ", section_id=" + section_id + ", is_for_course=" + is_for_course
                + ", is_submitted=" + is_submitted + ", do_it_later_count=" + do_it_later_count
                + ", is_reevaluate_request_sent=" + is_reevaluate_request_sent + ", start_date=" + start_date
                + ", end_date=" + end_date + "]";
    }

}
