package org.codeer.ICES4HU.Repository;

import java.util.stream.Collectors;

import org.codeer.ICES4HU.Entity.CommonMail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonMailRepository extends JpaRepository<CommonMail, Integer> {
}
