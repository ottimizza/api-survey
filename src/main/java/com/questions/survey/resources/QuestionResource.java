package com.questions.survey.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questions.survey.models.Question;
import com.questions.survey.repository.QuestionRepository;
import com.questions.survey.service.QuestionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api-survey/question")
@Api(value="API REST Survey")
@CrossOrigin(origins="*")
public class QuestionResource {
	
	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("/qst")
	@ApiOperation(value="Retorna uma lista de questões")
	public List<Question> listQuestion() {
		return questionService.findAll();
	}
	
	@GetMapping("/qst/{id}")
	@ApiOperation(value="Retorna uma única questão")
	public Question listQuestionById(@PathVariable(value="id") long id) {
		return questionService.findById(id);
	}
	
	@PostMapping("/qst")
	@ApiOperation(value="Cadastra uma questão")
	public Question saveQuestion(@RequestBody Question question) {
		return questionService.addQst(question);
	}
	
	@DeleteMapping("/qst/{id}")
	@ApiOperation(value="Deleta uma questão")
	public void deleteQuestion(@PathVariable(value="id") long id) {
		questionService.deleteQst(id);
	}
	
	@PutMapping("/qst")
	@ApiOperation(value="Atualiza uma questão")
	public void updateQuestion(@RequestBody Question question) {
		questionService.update(question);
	}

	
	@GetMapping("/page")
	public Page<Question> fetchByPage(Pageable pageable){
		return this.questionService.findAllByPage(pageable);
	}
	
}
