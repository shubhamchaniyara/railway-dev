package com.example.ram.repository;

import com.example.ram.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Quizrepo extends JpaRepository<Quiz,Integer> {

    @Query("SELECT q.Id FROM candidate q WHERE q.gamepin = :gamepin AND q.nickname = :nickname")
    Integer findUserIdByGamePinAndNickname(@Param("gamepin") Long gamepin, @Param("nickname") String nickname);
}
