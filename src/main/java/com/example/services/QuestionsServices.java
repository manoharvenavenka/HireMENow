package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Questions;
import com.example.entity.Vacancy;

@Service
public interface QuestionsServices {
void addQuestion(Questions question);
List<Questions> getByCompanyId(int companyId);
List<Questions> getByVacancyId(int vacancyId);
Questions getByQid(int questionId);
boolean updateQuestions(Questions questions);
boolean deleteQues(int questionId);
}
