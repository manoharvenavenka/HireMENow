    package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Questions;
import com.example.entity.Vacancy;
import com.example.services.QuestionsServices;

@Controller
@RequestMapping("api/v1")
public class QuestionController {

	@Autowired
	QuestionsServices QuesServ;

	@PostMapping("/addQuestions")
	public ResponseEntity<Object> addCompany(@RequestBody Questions qustions) {
		QuesServ.addQuestion(qustions);
		return new ResponseEntity<>("Company Added Welcome To Hire Me Now", HttpStatus.CREATED);
	}

	@GetMapping(value = "/viewQuestions/{companyId}")
	public ResponseEntity<Object> getQuestionsByCid(@PathVariable("companyId") int companyId) {

		List<Questions> test = QuesServ.getByCompanyId(companyId);

		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
	}
	
	
	@GetMapping(value = "/getQuestionsBy/{questionId}")
	public ResponseEntity<Object> getQuestionsQid(@PathVariable("questionId") int questionId) {

		Questions question = QuesServ.getByQid(questionId);

		ResponseEntity<Object> entity = new ResponseEntity<>(question, HttpStatus.OK);
		return entity;
	}

	@GetMapping(value = "/getQuestions/{vacancyId}")
	public ResponseEntity<Object> getQuestionsByVacId(@PathVariable("vacancyId") int vacancyId) {

		List<Questions> test = QuesServ.getByVacancyId(vacancyId);

		ResponseEntity<Object> entity = new ResponseEntity<>(test, HttpStatus.OK);
		return entity;
	}
	
	@PutMapping(value="/updateQuestions/{questionId}")
	public ResponseEntity<Object> updateVacancy(@PathVariable("questionId") int questionId, @RequestBody Questions questions)
	{
		
		boolean flag;
		
			flag = QuesServ.updateQuestions(questions);
		
		
		return new ResponseEntity<>(flag, HttpStatus.OK);
		
	}
	@DeleteMapping(value="/deleteQues/{questionId}")
	public ResponseEntity<Object> deleteQues(@PathVariable("questionId") int questionId){
		
		boolean flag;
		
			flag = QuesServ.deleteQues(questionId);
		
		
		return new ResponseEntity<>(flag,HttpStatus.OK);
		
	}
}
