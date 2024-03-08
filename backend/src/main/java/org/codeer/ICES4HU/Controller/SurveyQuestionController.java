package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.SurveyQuestion;
import org.codeer.ICES4HU.Repository.SurveyQuestionRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/surveyQuestions")
public class SurveyQuestionController {

    private SurveyQuestionRepository surveyQuestionRepository;

    record SurveyQuestionRequest(Integer survey_id, Integer question_id, Integer question_order) {
    }

    public SurveyQuestionController(SurveyQuestionRepository surveyRepository) {
        this.surveyQuestionRepository = surveyRepository;
    }

    @GetMapping()
    public List<SurveyQuestion> getAllSurveyQuestions() {
        return surveyQuestionRepository.findAll();
    }

    @PostMapping()
    public void addSurveyQuestion(@RequestBody SurveyQuestionRequest surveyQuestionRequest) {
        SurveyQuestion sq = new SurveyQuestion();

        sq.setSurvey_id(surveyQuestionRequest.survey_id());
        sq.setQuestion_id(surveyQuestionRequest.question_id());
        sq.setQuestion_order(surveyQuestionRequest.question_order());
        surveyQuestionRepository.save(sq);
    }

    @PutMapping("/{uid}")
    public void updateSurveyQuestion(
            @PathVariable("uid") Integer uid,
            @RequestBody SurveyQuestionRequest sqr) {
        SurveyQuestion sq = surveyQuestionRepository.findById(uid).orElseGet(() -> new SurveyQuestion());
        if (sqr.survey_id() != null)
            sq.setSurvey_id(sqr.survey_id());
        if (sqr.question_id() != null)
            sq.setQuestion_id(sqr.question_id());
        if (sqr.question_order() != null)
            sq.setQuestion_order(sqr.question_order());

        surveyQuestionRepository.save(sq);
    }

    @DeleteMapping("/{uid}")
    public void deleteSurveyQuestion(@PathVariable("uid") Integer uid) {
        surveyQuestionRepository.deleteById(uid);
    }
}
