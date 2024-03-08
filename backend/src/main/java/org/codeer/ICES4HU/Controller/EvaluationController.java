package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.Evaluation;
import org.codeer.ICES4HU.Repository.EvaluationRepository;
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
@RequestMapping("/api/v1/evaluations")
public class EvaluationController {

    private EvaluationRepository evaluationRepository;

    record EvaluationRequest(Integer student_id, Integer survey_id, Integer do_it_later_count, boolean is_submitted) {
    }

    public EvaluationController(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    @GetMapping()
    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    @PostMapping()
    public void addEvaluation(@RequestBody EvaluationRequest evaluationRequest) {
        Evaluation e = new Evaluation();
        e.setStudent_id(evaluationRequest.student_id());
        e.setSurvey_id(evaluationRequest.survey_id());
        e.setDo_it_later_count(evaluationRequest.do_it_later_count());
        e.setIs_submitted(evaluationRequest.is_submitted());

        evaluationRepository.save(e);
    }

    @PutMapping("/{uid}")
    public void updateEvaluation(
            @PathVariable("uid") Integer uid,
            @RequestBody EvaluationRequest er) {
        Evaluation e = evaluationRepository.findById(uid).orElseGet(() -> new Evaluation());

        if (er.student_id() != null)
            e.setStudent_id(er.student_id());

        if (er.survey_id() != null)
            e.setSurvey_id(er.survey_id());

        if (er.do_it_later_count() != null)
            e.setDo_it_later_count(er.do_it_later_count());

        e.setIs_submitted(er.is_submitted());

        evaluationRepository.save(e);
    }

    @DeleteMapping("/{uid}")
    public void deleteEvaluation(@PathVariable("uid") Integer uid) {
        evaluationRepository.deleteById(uid);
    }
}
