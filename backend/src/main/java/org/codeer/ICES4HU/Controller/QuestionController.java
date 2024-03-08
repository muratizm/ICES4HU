package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Repository.QuestionRepository;
import org.codeer.ICES4HU.Entity.Question;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/questions")

public class QuestionController {

    private QuestionRepository questionRepository;

    record QuestionRequest(Integer written_by_instructor, Integer written_by_department, Integer course_id,
            String question_type, boolean is_for_course, boolean is_required, String question_title,
            String question_text, String question_image_url, String choiceA, String choiceB, String choiceC,
            String choiceD, String choiceE) {
    }

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping()
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @PostMapping()
    public void addQuestion(@RequestBody QuestionRequest questionRequest) {
        Question s = new Question();
        s.setWritten_by_instructor(questionRequest.written_by_instructor());
        s.setWritten_by_department(questionRequest.written_by_department());
        s.setCourse_id(questionRequest.course_id());
        s.setQuestion_type(questionRequest.question_type());
        s.setIs_for_course(questionRequest.is_for_course());
        s.setIs_required(questionRequest.is_required());
        s.setQuestion_title(questionRequest.question_title());
        s.setQuestion_text(questionRequest.question_text());
        s.setQuestion_image_url(questionRequest.question_image_url());
        s.setChoiceA(questionRequest.choiceA());
        s.setChoiceB(questionRequest.choiceB());
        s.setChoiceC(questionRequest.choiceC());
        s.setChoiceD(questionRequest.choiceD());
        s.setChoiceE(questionRequest.choiceE());
        questionRepository.save(s);
    }

    @PutMapping("/{question_id}")
    public void updateQuestion(
            @PathVariable("question_id") Integer question_id,
            @RequestBody QuestionRequest qr) {
        Question q = questionRepository.findById(question_id).orElseGet(() -> new Question());
        if (qr.written_by_instructor() != null)
            q.setWritten_by_instructor(qr.written_by_instructor());
        if (qr.written_by_department() != null)
            q.setWritten_by_department(qr.written_by_department());
        if (qr.course_id() != null)
            q.setCourse_id(qr.course_id());
        if (qr.question_type() != null)
            q.setQuestion_type(qr.question_type());
        if (qr.is_for_course())
            q.setIs_for_course(qr.is_for_course());
        if (qr.is_required())
            q.setIs_required(qr.is_required());
        if (qr.question_title() != null)
            q.setQuestion_title(qr.question_title());
        if (qr.question_text() != null)
            q.setQuestion_text(qr.question_text());
        if (qr.question_image_url() != null)
            q.setQuestion_image_url(qr.question_image_url());
        if (qr.choiceA() != null)
            q.setChoiceA(qr.choiceA());
        if (qr.choiceB() != null)
            q.setChoiceB(qr.choiceB());
        if (qr.choiceC() != null)
            q.setChoiceC(qr.choiceC());
        if (qr.choiceD() != null)
            q.setChoiceD(qr.choiceD());
        q.setChoiceE(qr.choiceE());
        questionRepository.save(q);
    }

    @DeleteMapping("/{question_id}")
    public void deleteQuestion(@PathVariable("question_id") Integer question_id) {
        questionRepository.deleteById(question_id);
    }
}
