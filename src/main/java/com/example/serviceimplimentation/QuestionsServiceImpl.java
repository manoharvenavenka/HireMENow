package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Questions;
import com.example.entity.Vacancy;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.QuestionRepository;
import com.example.services.QuestionsServices;

@Service
public class QuestionsServiceImpl implements QuestionsServices {
	@Autowired
	QuestionRepository quesRep;

	@Override
	public void addQuestion(Questions question) {
		// TODO Auto-generated method stub
		quesRep.save(question);
	}

	@Override
	public List<Questions> getByCompanyId(int companyId) {
		List<Questions> questions = quesRep.findByCompanyId(companyId);

		// if (questions.isEmpty()) {
		// throw new ResourceNotFoundException("questions", "companyId", companyId);
		// }

		return questions;
	}

	@Override
	public List<Questions> getByVacancyId(int vacancyId) {
		List<Questions> questions = quesRep.findByVacancy_VacancyId(vacancyId);
		return questions;
	}

	@Override
	public Questions getByQid(int questionId) {
		Optional<Questions> question = quesRep.findById(questionId);
		Questions ques;
		if (question.isPresent()) {
			ques = question.get();
		} else {
			throw new ResourceNotFoundException("Vacancy", "questionId", questionId);
		}
		return ques;
	}

	@Override
	public boolean updateQuestions(Questions questions) {
		Optional<Questions> questi = quesRep.findById(questions.getQuestionId());
		if (questi.isPresent()) {
			quesRep.save(questions);
			return true;

		} else {
			return false;
		}
	}

@Override
public boolean deleteQues(int questionId) {
	Optional<Questions> question =quesRep.findById(questionId);
	if(question.isPresent()) {
		quesRep.deleteById(questionId);
		return true;
	}
	else 
	{
	return false;
}
}
}
