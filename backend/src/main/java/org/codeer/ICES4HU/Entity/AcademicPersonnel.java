package org.codeer.ICES4HU.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicPersonnel {
    @Id
    @SequenceGenerator(name = "personnel_id_sequence", sequenceName = "personnel_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "personnel_id_sequence", strategy = GenerationType.SEQUENCE)
    private Integer personnelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_of", referencedColumnName = "department_id")
    @JsonBackReference
    private Department managerOf;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String profilePictureUrl;
}