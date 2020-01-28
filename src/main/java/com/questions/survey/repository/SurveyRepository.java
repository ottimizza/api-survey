package com.questions.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questions.survey.models.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
