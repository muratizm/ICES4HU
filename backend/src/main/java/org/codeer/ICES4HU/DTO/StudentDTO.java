package org.codeer.ICES4HU.DTO;

import org.codeer.ICES4HU.Entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {
    private Integer studentId;
    private Department department;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String profilePictureUrl;
    // is_banned and password fields are excluded
}