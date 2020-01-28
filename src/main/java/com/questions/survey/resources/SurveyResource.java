package com.questions.survey.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questions.survey.commands.survey.RecebeArraySurvey;
import com.questions.survey.service.SurveyService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value="/api-survey")
@Api(value="API REST Survey")
@CrossOrigin(origins="*")
public class SurveyResource {

	@Autowired
	SurveyService surveyService;
	
	@PostMapping("/submit")
	public ResponseEntity<?> submit(@RequestBody RecebeArraySurvey survey) {
		return ResponseEntity.ok(surveyService.addSurvey(survey));
	}
	
}
