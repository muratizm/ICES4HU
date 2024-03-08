package org.codeer.ICES4HU.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @SequenceGenerator(name = "department_id_sequence", sequenceName = "department_id_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "department_id_sequence", strategy = GenerationType.SEQUENCE)

    private Integer department_id;
    private String name;

    @OneToOne(mappedBy = "managerOf")
    @JsonManagedReference
    @JsonIgnore
    // EqualsAndHashCode and ToString is excluded from Lombok in order to prevent
    // infinite loop and stackoverflow
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AcademicPersonnel manager;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    @JsonIgnore
    // EqualsAndHashCode and ToString is excluded from Lombok in order to prevent
    // infinite loop and stackoverflow
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<AcademicPersonnel> academicPersonnel;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    @JsonIgnore
    // EqualsAndHashCode and ToString is excluded from Lombok in order to prevent
    // infinite loop and stackoverflow
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Student> students;
}
