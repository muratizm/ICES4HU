package org.codeer.ICES4HU.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class CommonMail {
    @Id
    @SequenceGenerator(name = "common_mail_sequence", sequenceName = "common_mail_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "common_mail_sequence", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String common_mail_address;

    // One mail may be common mail for many students
    @OneToMany(mappedBy = "common_mail")
    @JsonManagedReference
    @JsonIgnore
    // EqualsAndHashCode and ToString is excluded from Lombok in order to prevent
    // infinite loop and stackoverflow
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<MailMerge> mailMerges = new HashSet<>();
}
