package com.questions.survey.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Survey")
@CrossOrigin(origins="*")
public class QuestionResource {

	@Autowired
	QuestionRepository questionRepository;
	
	
	@GetMapping("/question")
	@ApiOperation(value="Retorna uma lista de questões")
	public List<Question> listQuestion() {
		return questionRepository.findAll();
	}
	
	@GetMapping("/question/{id}")
	@ApiOperation(value="Retorna uma única questão")
	public Question listQuestionById(@PathVariable(value="id") long id) {
		return questionRepository.findById(id);
	}
	
	@PostMapping("/question")
	@ApiOperation(value="Cadastra uma questão")
	public Question saveQuestion(@RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	@DeleteMapping("/question")
	@ApiOperation(value="Delete uma questão")
	public void deleteQuestion(@RequestBody Question question) {
		questionRepository.delete(question);
	}
	
	@PutMapping("/question")
	@ApiOperation(value="Atualiza uma questão")
	public void updateQuestion(@RequestBody Question question) {
		questionRepository.save(question);
	}
	
}
