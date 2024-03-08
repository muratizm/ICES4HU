package org.codeer.ICES4HU.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class EvaluationAnswer {
    @Id
    @SequenceGenerator(name = "answer_id_sequence", sequenceName = "answer_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "answer_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer answer_id;
    private Integer evaluation_id;
    private Integer question_id;
    private boolean is_choiceA_selected;
    private boolean is_choiceB_selected;
    private boolean is_choiceC_selected;
    private boolean is_choiceD_selected;
    private boolean is_choiceE_selected;
    private String open_ended_answer;

    public EvaluationAnswer() {
    }

    public EvaluationAnswer(Integer answer_id, Integer evaluation_id, Integer question_id,
            boolean is_choiceA_selected,
            boolean is_choiceB_selected, boolean is_choiceC_selected, boolean is_choiceD_selected,
            boolean is_choiceE_selected, String open_ended_answer) {
        this.answer_id = answer_id;
        this.evaluation_id = evaluation_id;
        this.question_id = question_id;
        this.is_choiceA_selected = is_choiceA_selected;
        this.is_choiceB_selected = is_choiceB_selected;
        this.is_choiceC_selected = is_choiceC_selected;
        this.is_choiceD_selected = is_choiceD_selected;
        this.is_choiceE_selected = is_choiceE_selected;
        this.open_ended_answer = open_ended_answer;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Integer getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(Integer evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public boolean isIs_choiceA_selected() {
        return is_choiceA_selected;
    }

    public void setIs_choiceA_selected(boolean is_choiceA_selected) {
        this.is_choiceA_selected = is_choiceA_selected;
    }

    public boolean isIs_choiceB_selected() {
        return is_choiceB_selected;
    }

    public void setIs_choiceB_selected(boolean is_choiceB_selected) {
        this.is_choiceB_selected = is_choiceB_selected;
    }

    public boolean isIs_choiceC_selected() {
        return is_choiceC_selected;
    }

    public void setIs_choiceC_selected(boolean is_choiceC_selected) {
        this.is_choiceC_selected = is_choiceC_selected;
    }

    public boolean isIs_choiceD_selected() {
        return is_choiceD_selected;
    }

    public void setIs_choiceD_selected(boolean is_choiceD_selected) {
        this.is_choiceD_selected = is_choiceD_selected;
    }

    public boolean isIs_choiceE_selected() {
        return is_choiceE_selected;
    }

    public void setIs_choiceE_selected(boolean is_choiceE_selected) {
        this.is_choiceE_selected = is_choiceE_selected;
    }

    public String getOpen_ended_answer() {
        return open_ended_answer;
    }

    public void setOpen_ended_answer(String open_ended_answer) {
        this.open_ended_answer = open_ended_answer;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((answer_id == null) ? 0 : answer_id.hashCode());
        result = prime * result + ((evaluation_id == null) ? 0 : evaluation_id.hashCode());
        result = prime * result + ((question_id == null) ? 0 : question_id.hashCode());
        result = prime * result + (is_choiceA_selected ? 1231 : 1237);
        result = prime * result + (is_choiceB_selected ? 1231 : 1237);
        result = prime * result + (is_choiceC_selected ? 1231 : 1237);
        result = prime * result + (is_choiceD_selected ? 1231 : 1237);
        result = prime * result + (is_choiceE_selected ? 1231 : 1237);
        result = prime * result + ((open_ended_answer == null) ? 0 : open_ended_answer.hashCode());
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
        EvaluationAnswer other = (EvaluationAnswer) obj;

        if (answer_id == null) {
            if (other.answer_id != null)
                return false;
        } else if (!answer_id.equals(other.answer_id))
            return false;

        if (evaluation_id == null) {
            if (other.evaluation_id != null)
                return false;
        } else if (!evaluation_id.equals(other.evaluation_id))
            return false;

        if (question_id == null) {
            if (other.question_id != null)
                return false;
        } else if (!question_id.equals(other.question_id))
            return false;

        if (is_choiceA_selected != other.is_choiceA_selected)
            return false;
        if (is_choiceB_selected != other.is_choiceB_selected)
            return false;
        if (is_choiceC_selected != other.is_choiceC_selected)
            return false;
        if (is_choiceD_selected != other.is_choiceD_selected)
            return false;
        if (is_choiceE_selected != other.is_choiceE_selected)
            return false;

        if (open_ended_answer == null) {
            if (other.open_ended_answer != null)
                return false;
        } else if (!open_ended_answer.equals(other.open_ended_answer))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "EvaluationAnswer [answerId=" + answer_id + ", evaluationId=" + evaluation_id + ", questionId="
                + question_id
                + ", is_choiceA_selected=" + is_choiceA_selected + ", is_choiceB_selected=" + is_choiceB_selected
                + ", is_choiceC_selected=" + is_choiceC_selected + ", is_choiceD_selected=" + is_choiceD_selected
                + ", is_choiceE_selected=" + is_choiceE_selected + ", open_ended_answer=" + open_ended_answer + "]";
    }

}