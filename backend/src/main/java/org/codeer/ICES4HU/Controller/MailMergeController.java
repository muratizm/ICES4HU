package org.codeer.ICES4HU.Controller;

import java.util.List;

import org.codeer.ICES4HU.DTO.MailMergeDTO;
import org.codeer.ICES4HU.Entity.MailMerge;
import org.codeer.ICES4HU.Service.MailMergeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/mailmerges")
public class MailMergeController {
    private MailMergeService mailMergeService;

    record MailMergeRequest(String mailMergeAddress, Integer studentId) {
    }

    public MailMergeController(MailMergeService mailMergeService) {
        this.mailMergeService = mailMergeService;
    }

    @GetMapping()
    public List<MailMergeDTO> getAllMailMerges() {
        return mailMergeService.getAllMailMerges();
    }

    @GetMapping("/{commonMailAddress}")
    public MailMergeDTO getMailMerge(String commonMailAddress) throws Exception {
        return mailMergeService.getMailMerge(commonMailAddress);
    }

    @PostMapping()
    public void addMailMergeAddress(@RequestBody MailMergeRequest mmr) throws Exception {
        mailMergeService.addStudentToCommonMail(mmr.studentId(), mmr.mailMergeAddress());
    }

    @DeleteMapping()
    public void deleteMergeAddress(@RequestParam("commonMailAddress") String commonMailAddress,
            @RequestParam("studentId") Integer studentId) throws Exception {
        mailMergeService.removeStudentFromCommonMail(studentId, commonMailAddress);
    }
}
