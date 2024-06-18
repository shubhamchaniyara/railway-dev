package com.example.ram.controller;


import com.example.ram.model.Frontend;
import com.example.ram.model.Gamepin;
import com.example.ram.service.FrontService;
import com.example.ram.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/front")
public class Frontendcontro {

    private FrontService frontService;

    @Autowired
    public Frontendcontro(FrontService frontService) {
        this.frontService = frontService;
    }
    @PostMapping("/gstart")
    public void saveQuizData(@RequestBody Frontend frontend) {
        frontService.saveQuiz(frontend);
    }

    @GetMapping("/getstart")
    public List<Frontend> getQuizData() {
        return frontService.getAllQuizzes();
    }
}
