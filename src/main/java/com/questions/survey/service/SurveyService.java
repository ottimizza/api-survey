package com.questions.survey.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions.survey.commands.survey.RecebeArraySurvey;
import com.questions.survey.dto.SurveyDTO;
import com.questions.survey.mappers.SurveyMapper;
import com.questions.survey.models.Survey;
import com.questions.survey.repository.SurveyRepository;

@Service
public class SurveyService {

	@Autowired
	SurveyRepository surveyRepository;
	
	public List<SurveyDTO> addSurvey(RecebeArraySurvey addSurvey) {
				
		List<Survey> results = new ArrayList<>();
		
		List<Survey> survey = addSurvey.getQuestions().stream().map((q) -> {
			return SurveyMapper.fromDto(q).toBuilder()
					.idOrg(addSurvey.getIdOrg())
					.idUser(addSurvey.getIdUser()).build();
		}).collect(Collectors.toList());
		surveyRepository.saveAll(survey).forEach(results::add);
		return SurveyMapper.fromEntities(results);
		
	}
	
}
