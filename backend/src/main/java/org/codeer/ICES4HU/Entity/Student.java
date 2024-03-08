package org.codeer.ICES4HU.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Student {
    @Id
    @SequenceGenerator(name = "studentIdSequence", sequenceName = "studentIdSequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "studentIdSequence", strategy = GenerationType.SEQUENCE)
    private Integer studentId;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    // One student may be in many common mail merges.
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    // EqualsAndHashCode and ToString is excluded from Lombok in order to prevent
    // infinite loop and stackoverflow
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MailMerge> mailMerges;

    private String username;
    private String name;
    private String surname;
    private String email;
    private String profilePictureUrl;
    private boolean isBanned;
}