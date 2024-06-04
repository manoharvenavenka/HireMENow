package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.TestResult;

public interface TestResultRepository extends JpaRepository<TestResult, Integer>{
	 
	@Query(value = "SELECT vacancy_id, SUM(score) AS score, " +
            "COUNT(selected_option) AS selected_option_count, " +
            "result, " +
            "COUNT(*) AS count " +
            "FROM testresult " +
            "WHERE result IN ('correct', 'incorrect') AND user_id = ?1 " +
            "GROUP BY vacancy_id, result", nativeQuery = true)
List<Object[]> getScoreAndCountByResultAndUserId(int userId);
	
	
}
