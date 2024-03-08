package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.Entity.EvaluationAnswer;
import org.codeer.ICES4HU.Repository.EvaluationAnswerRepository;
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
@RequestMapping("/api/v1/answers")
public class EvaluationAnswerController {
    private EvaluationAnswerRepository evaluationAnswerRepository;

    record EvaluationAnswerRequest(Integer evaluation_id, Integer question_id, boolean is_choiceA_selected,
            boolean is_choiceB_selected, boolean is_choiceC_selected,
            boolean is_choiceD_selected, boolean is_choiceE_selected,
            String open_ended_answer) {

    }

    public EvaluationAnswerController(EvaluationAnswerRepository evaluationAnswerRepository) {
        this.evaluationAnswerRepository = evaluationAnswerRepository;
    }

    @GetMapping()
    public List<EvaluationAnswer> getAllEvaluationAnswers() {
        return evaluationAnswerRepository.findAll();
    }

    @PostMapping
    public void addEvaluationAnswer(@RequestBody EvaluationAnswerRequest ear) {
        EvaluationAnswer ea = new EvaluationAnswer();
        ea.setEvaluation_id(ear.evaluation_id());
        ea.setQuestion_id(ear.question_id());
        ea.setIs_choiceA_selected(ear.is_choiceA_selected());
        ea.setIs_choiceB_selected(ear.is_choiceB_selected());
        ea.setIs_choiceC_selected(ear.is_choiceC_selected());
        ea.setIs_choiceD_selected(ear.is_choiceD_selected());
        ea.setIs_choiceE_selected(ear.is_choiceE_selected());
        ea.setOpen_ended_answer(ear.open_ended_answer());
        evaluationAnswerRepository.save(ea);
    }

    @PutMapping("/{answerId}")
    public void updateAnswer(
            @PathVariable("answerId") Integer answer_id,
            @RequestBody EvaluationAnswerRequest ear) {
        EvaluationAnswer ea = evaluationAnswerRepository.findById(answer_id)
                .orElseGet(() -> new EvaluationAnswer());

        if (ear.evaluation_id() != null)
            ea.setEvaluation_id(ear.evaluation_id());
        if (ear.question_id() != null)
            ea.setQuestion_id(ear.question_id());
        ea.setIs_choiceA_selected(ear.is_choiceA_selected());
        ea.setIs_choiceB_selected(ear.is_choiceB_selected());
        ea.setIs_choiceC_selected(ear.is_choiceC_selected());
        ea.setIs_choiceD_selected(ear.is_choiceD_selected());
        ea.setIs_choiceE_selected(ear.is_choiceE_selected());
        if (ear.open_ended_answer() != null)
            ea.setOpen_ended_answer(ear.open_ended_answer());

        evaluationAnswerRepository.save(ea);
    }

    @DeleteMapping("/{answerId}")
    public void deleteEvaluationAnswer(@PathVariable("answerId") Integer answer_id) {
        evaluationAnswerRepository.deleteById(answer_id);
    }
}