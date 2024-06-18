package com.example.ram.controller;


import com.example.ram.model.Gamepin;
import com.example.ram.model.Quiz;
import com.example.ram.repository.Quizrepo;
import com.example.ram.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quizcontro {

    private QuizService quizService;

    @Autowired
    public Quizcontro(QuizService quizService) {
        this.quizService = quizService;
    }

     @Autowired
    private Quizrepo quizrepo;

    
    @PostMapping("/tquiz")
    public void saveQuizData(@RequestBody Quiz quiz) {
        quizService.saveQuiz(quiz);
    }

    @GetMapping("/QuizPlay")
    public List<Quiz> getQuizData() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/getScore/{userid}")
    public Integer getUserScore(@PathVariable Integer userid) {
        Quiz userQuiz = quizService.getUserQuiz(userid);
        if (userQuiz != null) {
            return userQuiz.getScore();
        } else {
            return 0;
        }
    }

    @PostMapping("/updateScore/{userid}")
    public void updateScore(@PathVariable Integer userid) {
        Quiz userQuiz = quizService.getUserQuiz(userid);
        if (userQuiz != null) {
            Integer currentScore = userQuiz.getScore();
            if (currentScore == null) {
                currentScore = 0;
            }
            userQuiz.setScore(currentScore + 1);
            quizService.saveQuiz(userQuiz);
        }
    }

     @GetMapping("/getUserIdByNickname/{gamepin}/{nickname}")
    public ResponseEntity<Integer> getUserIdByNickname(@PathVariable Long gamepin, @PathVariable String nickname) {
        Integer userId = quizrepo.findUserIdByGamePinAndNickname(gamepin, nickname);
        if (userId != null) {
            return ResponseEntity.ok(userId);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }


}
