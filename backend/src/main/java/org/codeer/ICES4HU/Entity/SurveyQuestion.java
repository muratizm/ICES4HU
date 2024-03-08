package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class SurveyQuestion {
    @Id
    @SequenceGenerator(name = "uid_sequence", sequenceName = "uid_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "uid_sequence", strategy = GenerationType.SEQUENCE)
    private Integer uid;
    private Integer survey_id;
    private Integer question_id;
    private Integer question_order;

    public SurveyQuestion() {
    }

    public SurveyQuestion(Integer uid, Integer survey_id, Integer question_id, Integer question_order) {
        this.uid = uid;
        this.survey_id = survey_id;
        this.question_id = question_id;
        this.question_order = question_order;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(Integer survey_id) {
        this.survey_id = survey_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getQuestion_order() {
        return question_order;
    }

    public void setQuestion_order(Integer question_order) {
        this.question_order = question_order;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        result = prime * result + ((survey_id == null) ? 0 : survey_id.hashCode());
        result = prime * result + ((question_id == null) ? 0 : question_id.hashCode());
        result = prime * result + ((question_order == null) ? 0 : question_order.hashCode());
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
        SurveyQuestion other = (SurveyQuestion) obj;

        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;

        if (survey_id == null) {
            if (other.survey_id != null)
                return false;
        } else if (!survey_id.equals(other.survey_id))
            return false;

        if (question_id == null) {
            if (other.question_id != null)
                return false;
        } else if (!question_id.equals(other.question_id))
            return false;

        if (question_order == null) {
            if (other.question_order != null)
                return false;
        } else if (!question_order.equals(other.question_order))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "SurveyQuestion [uid=" + uid + ", survey_id=" + survey_id + ", question_id=" + question_id
                + ", question_order="
                + question_order + "]";
    }

}
