package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Repository.QuestionTypeRepository;
import org.codeer.ICES4HU.Entity.QuestionType;
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
@RequestMapping("/api/v1/questionTypes")
public class QuestionTypeController {

    private QuestionTypeRepository questionTypeRepository;

    record QuestionTypeRequest(String type) {
    }

    public QuestionTypeController(QuestionTypeRepository questionTypeRepository) {
        this.questionTypeRepository = questionTypeRepository;
    }

    @GetMapping()
    public List<QuestionType> getAllQuestionTypes() {
        return questionTypeRepository.findAll();
    }

    @PostMapping()
    public void addQuestionType(@RequestBody QuestionTypeRequest questionTypeRequest) {
        QuestionType qt = new QuestionType();
        qt.setType(questionTypeRequest.type());
        questionTypeRepository.save(qt);
    }

    @PutMapping("/{question_type_id}")
    public void updateQuestionType(
            @PathVariable("question_type_id") Integer question_type_id,
            @RequestBody QuestionTypeRequest qtr) {
        QuestionType qt = questionTypeRepository.findById(question_type_id).orElseGet(() -> new QuestionType());
        if (qtr.type() != null)
            qt.setType(qt.getType());
        questionTypeRepository.save(qt);
    }

    @DeleteMapping("/{question_type_id}")
    public void deleteQuestionType(@PathVariable("question_type_id") Integer question_type_id) {
        questionTypeRepository.deleteById(question_type_id);
    }
}
