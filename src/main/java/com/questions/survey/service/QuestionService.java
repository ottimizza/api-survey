package com.questions.survey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.questions.survey.models.Question;
import com.questions.survey.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	public List<Question> findAll() {
		List<Question> allQst = new ArrayList<Question>();
		
		questionRepository.findAll().forEach(q -> allQst.add(q));
		return allQst;
	}
	
	public Question findById(long id){
		return questionRepository.findById(id);
	}
	
	public Question addQst(Question question) {
		return questionRepository.save(question);
	}
	
	public void update(Question question) {
		questionRepository.save(question);
	}
	
	public void deleteQst(Long id) {
		questionRepository.deleteById(id);
	}
	
	public Page<Question> findAllByPage(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}
	
}
