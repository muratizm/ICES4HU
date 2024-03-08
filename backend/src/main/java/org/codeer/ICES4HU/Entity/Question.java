package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Question {
    @Id
    @SequenceGenerator(name = "question_id_sequence", sequenceName = "question_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "question_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer question_id;
    private Integer written_by_instructor;
    private Integer written_by_department;
    private Integer course_id;
    private String question_type;
    private boolean is_for_course;
    private boolean is_required;
    private String question_title;
    private String question_text;
    private String question_image_url;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String choiceE;

    public Question() {
    }

    public Question(Integer question_id, Integer written_by_instructor, Integer written_by_department,
            Integer course_id, String question_type, boolean is_for_course, boolean is_required, String question_title,
            String question_text, String question_image_url, String choiceA, String choiceB, String choiceC,
            String choiceD, String choiceE) {
        this.question_id = question_id;
        this.written_by_instructor = written_by_instructor;
        this.written_by_department = written_by_department;
        this.course_id = course_id;
        this.question_type = question_type;
        this.is_for_course = is_for_course;
        this.is_required = is_required;
        this.question_title = question_title;
        this.question_text = question_text;
        this.question_image_url = question_image_url;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.choiceE = choiceE;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getWritten_by_instructor() {
        return written_by_instructor;
    }

    public void setWritten_by_instructor(Integer written_by_instructor) {
        this.written_by_instructor = written_by_instructor;
    }

    public Integer getWritten_by_department() {
        return written_by_department;
    }

    public void setWritten_by_department(Integer written_by_department) {
        this.written_by_department = written_by_department;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public boolean isIs_for_course() {
        return is_for_course;
    }

    public void setIs_for_course(boolean is_for_course) {
        this.is_for_course = is_for_course;
    }

    public boolean isIs_required() {
        return is_required;
    }

    public void setIs_required(boolean is_required) {
        this.is_required = is_required;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getQuestion_image_url() {
        return question_image_url;
    }

    public void setQuestion_image_url(String question_image_url) {
        this.question_image_url = question_image_url;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getChoiceE() {
        return choiceE;
    }

    public void setChoiceE(String choiceE) {
        this.choiceE = choiceE;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((question_id == null) ? 0 : question_id.hashCode()); // Integer
        result = prime * result + ((written_by_instructor == null) ? 0 : written_by_instructor.hashCode());
        result = prime * result + ((written_by_department == null) ? 0 : written_by_department.hashCode());
        result = prime * result + ((course_id == null) ? 0 : course_id.hashCode());
        result = prime * result + ((question_type == null) ? 0 : question_type.hashCode());
        result = prime * result + (is_for_course ? 1231 : 1237);
        result = prime * result + (is_required ? 1231 : 1237);
        result = prime * result + ((question_title == null) ? 0 : question_title.hashCode());
        result = prime * result + ((question_text == null) ? 0 : question_text.hashCode());
        result = prime * result + ((question_image_url == null) ? 0 : question_image_url.hashCode());
        result = prime * result + ((choiceA == null) ? 0 : choiceA.hashCode());
        result = prime * result + ((choiceB == null) ? 0 : choiceB.hashCode());
        result = prime * result + ((choiceC == null) ? 0 : choiceC.hashCode());
        result = prime * result + ((choiceD == null) ? 0 : choiceD.hashCode());
        result = prime * result + ((choiceE == null) ? 0 : choiceE.hashCode());

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
        Question other = (Question) obj;
        if (question_id == null) {
            if (other.question_id != null)
                return false;
        } else if (!question_id.equals(other.question_id))
            return false;

        if (written_by_instructor == null) {
            if (other.written_by_instructor != null)
                return false;
        } else if (!written_by_instructor.equals(other.written_by_instructor))
            return false;

        if (written_by_department == null) {
            if (other.written_by_department != null)
                return false;
        } else if (!written_by_department.equals(other.written_by_department))
            return false;

        if (course_id == null) {
            if (other.course_id != null)
                return false;
        } else if (!course_id.equals(other.course_id))
            return false;

        if (question_type == null) { // string
            if (other.question_type != null)
                return false;
        } else if (!question_type.equals(other.question_type))
            return false;

        if (is_for_course != other.is_for_course) // boolean
            return false;

        if (is_required != other.is_required) // boolean
            return false;

        if (question_title == null) { // string
            if (other.question_title != null)
                return false;
        } else if (!question_title.equals(other.question_title))
            return false;

        if (question_text == null) { // string
            if (other.question_text != null)
                return false;
        } else if (!question_text.equals(other.question_text))
            return false;

        if (question_image_url == null) { // string
            if (other.question_image_url != null)
                return false;
        } else if (!question_image_url.equals(other.question_image_url))
            return false;

        if (choiceA == null) {
            if (other.choiceA != null)
                return false;
        } else if (!choiceA.equals(other.choiceA))
            return false;

        if (choiceB == null) {
            if (other.choiceB != null)
                return false;
        } else if (!choiceB.equals(other.choiceB))
            return false;

        if (choiceC == null) {
            if (other.choiceC != null)
                return false;
        } else if (!choiceC.equals(other.choiceC))
            return false;

        if (choiceD == null) {
            if (other.choiceD != null)
                return false;
        } else if (!choiceD.equals(other.choiceD))
            return false;

        if (choiceE == null) {
            if (other.choiceE != null)
                return false;
        } else if (!choiceE.equals(other.choiceE))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Question [question_id=" + question_id + ", written_by_instructor=" + written_by_instructor
                + ", written_by_department=" + written_by_department + ", course_id="
                + course_id + ", question_type=" + question_type + ", is_for_course=" + is_for_course + ", is_required="
                + is_required + ", question_title=" + question_title + ", question_text=" + question_text
                + ", question_image_url=" + question_image_url + ", choiceA=" + choiceA + ", choiceB=" + choiceB
                + ", choiceC=" + choiceC + ", choiceD=" + choiceD + ", choiceE=" + choiceE + "]";
    }
}
