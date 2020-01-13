package com.questions.survey.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value="/api")
public class QuestionResource {

	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/question")
	public List<Question> listQuestion() {
		return questionRepository.findAll();
	}
	
	@GetMapping("/question/{id}")
	public Question listQuestionById(@PathVariable(value="id") long id) {
		return questionRepository.findById(id);
	}
	
	@PostMapping("/question")
	public Question saveQuestion(@RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	@DeleteMapping("/question")
	public void deleteQuestion(@RequestBody Question question) {
		questionRepository.delete(question);
	}
	
	@PutMapping("/question")
	public void updateQuestion(@RequestBody Question question) {
		questionRepository.save(question);
	}
	
}