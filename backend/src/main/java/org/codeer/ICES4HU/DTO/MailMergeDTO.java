package org.codeer.ICES4HU.DTO;

import java.util.Set;

import org.codeer.ICES4HU.Entity.Student;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailMergeDTO {
    private Set<Student> students;
    private String commonMailAddress;
}
