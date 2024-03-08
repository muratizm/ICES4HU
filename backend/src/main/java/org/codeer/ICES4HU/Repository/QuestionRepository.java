package org.codeer.ICES4HU.Repository;

import org.codeer.ICES4HU.Entity.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
