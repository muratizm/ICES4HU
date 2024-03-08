package org.codeer.ICES4HU.DTO;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SemesterDTO {
    // semester_id field is excluded
    private String name;
    private Date start_date;
    private Date end_date;
    // is_active field is excluded
}
