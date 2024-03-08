package org.codeer.ICES4HU.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.codeer.ICES4HU.DTO.MailMergeDTO;
import org.codeer.ICES4HU.Entity.CommonMail;
import org.codeer.ICES4HU.Entity.MailMerge;
import org.codeer.ICES4HU.Entity.Student;
import org.codeer.ICES4HU.Repository.CommonMailRepository;
import org.codeer.ICES4HU.Repository.MailMergeRepository;
import org.codeer.ICES4HU.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class MailMergeService {
    private final MailMergeRepository mailMergeRepository;
    private final CommonMailRepository commonMailRepository;
    private final StudentRepository studentRepository;

    public MailMergeService(MailMergeRepository mailMergeRepository, CommonMailRepository commonMailRepository,
            StudentRepository studentRepository) {
        this.mailMergeRepository = mailMergeRepository;
        this.commonMailRepository = commonMailRepository;
        this.studentRepository = studentRepository;
    }

    public MailMergeDTO convertEntityToDTO(CommonMail commonMail) {
        String commonMailAddress = commonMail.getCommon_mail_address();
        MailMergeDTO mailMergeDTO = new MailMergeDTO();
        mailMergeDTO.setCommonMailAddress(commonMailAddress);
        Set<Student> students = commonMail
                .getMailMerges()
                .stream()
                .map(mm -> mm.getStudent())
                .collect(Collectors.toSet());
        mailMergeDTO.setStudents(students);
        return mailMergeDTO;
    }

    public MailMergeDTO convertEntityToDTO(MailMerge mailMerge) {
        CommonMail commonMail = mailMerge.getCommon_mail();
        return convertEntityToDTO(commonMail);
    }

    public MailMergeDTO getMailMerge(String commonMailAddress) throws Exception {
        CommonMail commonMail = commonMailRepository
                .findAll()
                .stream()
                .filter(cm -> cm.getCommon_mail_address() == commonMailAddress)
                .findFirst()
                .orElseThrow(() -> new Exception("No such common mail address."));
        return convertEntityToDTO(commonMail);
    }

    public List<MailMergeDTO> getAllMailMerges() {
        return commonMailRepository
                .findAll()
                .stream()
                .map(cm -> convertEntityToDTO(cm))
                .collect(Collectors.toList());
    }

    public Optional<CommonMail> getCommonMail(String mailAddress) {
        for (CommonMail cm : commonMailRepository.findAll()) {
            if (cm.getCommon_mail_address().equals(mailAddress))
                return Optional.of(cm);
        }
        return Optional.empty();
    }

    public Optional<MailMerge> getMailMerge(String commonMailAddress, Integer studentId) {
        for (MailMerge mm : mailMergeRepository.findAll()) {
            if (mm.getCommon_mail().getCommon_mail_address().equals(commonMailAddress)
                    && mm.getStudent().getStudentId() == studentId)
                return Optional.of(mm);
        }
        return Optional.empty();
    }

    public CommonMail addCommonMail(String commonMailAddress) {
        var commonMail = new CommonMail();
        commonMail.setCommon_mail_address(commonMailAddress);
        return commonMailRepository.save(commonMail);
    }

    public Integer addStudentToCommonMail(Integer studentId, String commonMailAddress) throws Exception {
        // Get or create common mail
        CommonMail commonMail = getCommonMail(commonMailAddress)
                .orElseGet(() -> addCommonMail(commonMailAddress));
        // Get student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("student does not exist"));
        // Add student to the common mail
        MailMerge mailMerge = new MailMerge();
        mailMerge.setCommon_mail(commonMail);
        mailMerge.setStudent(student);
        MailMerge saved = mailMergeRepository.save(mailMerge);
        // Add mailMerge to the commonMail
        commonMail.getMailMerges().add(saved);
        return saved.getId();
    }

    public void removeStudentFromCommonMail(Integer studentId, String commonMailAddress) throws Exception {
        // Get commonMail or throw error if it does not exist
        CommonMail commonMail = getCommonMail(commonMailAddress).orElseThrow();
        // Get student or throw error if it does not exist
        studentRepository.findById(studentId).orElseThrow();
        // Get and delete mailMerge or throw error if it does not exist
        getMailMerge(commonMailAddress, studentId)
                .ifPresent(
                        mm -> {
                            // Remove mailMerge from commonMail
                            commonMail.getMailMerges().remove(mm);
                            // Delete mailMerge
                            mailMergeRepository.deleteById(mm.getId());
                        });
    }
}
