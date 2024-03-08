package org.codeer.ICES4HU.Controller;

import java.sql.Date;
import java.util.List;

import org.codeer.ICES4HU.Entity.Survey;
import org.codeer.ICES4HU.Repository.SurveyRepository;
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
@RequestMapping("/api/v1/surveys")
public class SurveyController {

    private SurveyRepository surveyRepository;

    record SurveyRequest(Integer section_id, boolean is_for_course, boolean is_submitted, Integer do_it_later_count,
            boolean is_reevaluate_request_sent, Long start_date, Long end_date) {
    }

    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping()
    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    @PostMapping()
    public void addSurvey(@RequestBody SurveyRequest surveyRequest) {
        Survey s = new Survey();
        s.setSection_id(surveyRequest.section_id());
        s.setIs_for_course(surveyRequest.is_for_course());
        s.setIs_submitted(surveyRequest.is_submitted());
        s.setDo_it_later_count(surveyRequest.do_it_later_count());
        s.setIs_reevaluate_request_sent(surveyRequest.is_reevaluate_request_sent());
        s.setStart_date(new Date(surveyRequest.start_date()));
        s.setEnd_date(new Date(surveyRequest.end_date()));
        surveyRepository.save(s);
    }

    @PutMapping("/{survey_id}")
    public void updateSurvey(
            @PathVariable("survey_id") Integer survey_id,
            @RequestBody SurveyRequest sr) {
        Survey s = surveyRepository.findById(survey_id).orElseGet(() -> new Survey());
        if (sr.section_id() != null)
            s.setSection_id(sr.section_id());
        s.setIs_for_course(sr.is_for_course());
        s.setIs_submitted(sr.is_submitted());
        if (sr.do_it_later_count() != null)
            s.setDo_it_later_count(sr.do_it_later_count());
        s.setIs_reevaluate_request_sent(sr.is_reevaluate_request_sent());
        if (sr.start_date() != null)
            s.setStart_date(new Date(sr.start_date()));
        if (sr.end_date() != null)
            s.setEnd_date(new Date(sr.end_date()));
        surveyRepository.save(s);
    }

    @DeleteMapping("/{survey_id}")
    public void deleteSurvey(@PathVariable("survey_id") Integer survey_id) {
        surveyRepository.deleteById(survey_id);
    }
}
