package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Evaluation {
    @Id
    @SequenceGenerator(name = "evaluation_id_sequence", sequenceName = "evaluation_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "evaluation_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer evaluation_id;
    private Integer student_id;
    private Integer survey_id;
    private Integer do_it_later_count;
    private boolean is_submitted;

    public Evaluation() {
    }

    public Evaluation(Integer evaluation_id, Integer student_id, Integer survey_id, Integer do_it_later_count,
            boolean is_submitted) {
        this.evaluation_id = evaluation_id;
        this.student_id = student_id;
        this.survey_id = survey_id;
        this.do_it_later_count = do_it_later_count;
        this.is_submitted = is_submitted;
    }

    public Integer getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(Integer evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getDo_it_later_count() {
        return do_it_later_count;
    }

    public void setDo_it_later_count(Integer do_it_later_count) {
        this.do_it_later_count = do_it_later_count;
    }

    public boolean isIs_submitted() {
        return is_submitted;
    }

    public void setIs_submitted(boolean is_submitted) {
        this.is_submitted = is_submitted;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((evaluation_id == null) ? 0 : evaluation_id.hashCode());
        result = prime * result + ((student_id == null) ? 0 : student_id.hashCode());
        result = prime * result + ((survey_id == null) ? 0 : survey_id.hashCode());
        result = prime * result + ((do_it_later_count == null) ? 0 : do_it_later_count.hashCode());
        result = prime * result + (is_submitted ? 1231 : 1237);
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
        Evaluation other = (Evaluation) obj;
        if (evaluation_id == null) {
            if (other.evaluation_id != null)
                return false;
        } else if (!evaluation_id.equals(other.evaluation_id))
            return false;
        if (student_id == null) {
            if (other.student_id != null)
                return false;
        } else if (!student_id.equals(other.student_id))
            return false;
        if (survey_id == null) {
            if (other.survey_id != null)
                return false;
        } else if (!survey_id.equals(other.survey_id))
            return false;
        if (do_it_later_count == null) {
            if (other.do_it_later_count != null)
                return false;
        } else if (!do_it_later_count.equals(other.do_it_later_count))
            return false;
        if (is_submitted != other.is_submitted)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Evaluation [evaluation_id=" + evaluation_id + ", student_id=" + student_id + ", survey_id=" + survey_id
                + ", do_it_later_count=" + do_it_later_count + ", is_submitted=" + is_submitted + "]";
    }

}
