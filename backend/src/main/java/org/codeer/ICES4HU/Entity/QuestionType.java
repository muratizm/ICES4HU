package org.codeer.ICES4HU.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Entity;

@Entity
public class QuestionType {
    @Id
    @SequenceGenerator(name = "question_type_id_sequence", sequenceName = "question_type_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "question_type_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer question_type_id;
    private String type;

    public QuestionType() {

    }

    public QuestionType(Integer question_type_id, String type) {
        this.question_type_id = question_type_id;
        this.type = type;
    }

    public Integer getQuestion_type_id() {
        return question_type_id;
    }

    public void setQuestion_type_id(Integer question_type_id) {
        this.question_type_id = question_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((question_type_id == null) ? 0 : question_type_id.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        QuestionType other = (QuestionType) obj;
        if (question_type_id == null) {
            if (other.question_type_id != null)
                return false;
        } else if (!question_type_id.equals(other.question_type_id))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "QuestionType [question_type_id=" + question_type_id + ", type=" + type + "]";
    }

}
