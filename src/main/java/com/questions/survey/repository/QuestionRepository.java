package com.questions.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questions.survey.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Question findById(long id);
	
}
