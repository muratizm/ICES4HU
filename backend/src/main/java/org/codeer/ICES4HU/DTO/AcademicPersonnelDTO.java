package org.codeer.ICES4HU.DTO;

import org.codeer.ICES4HU.Entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AcademicPersonnelDTO {

    private Department department;
    private Department managerOf;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String profilePictureUrl;
    // personnel_id and password fields are excluded
}
