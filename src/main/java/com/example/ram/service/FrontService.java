package com.example.ram.service;

import com.example.ram.model.Frontend;
import com.example.ram.model.Gamepin;
import com.example.ram.repository.Frontrepo;
import com.example.ram.repository.Gamepinrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FrontService {

    private final Frontrepo frontrepo;

    @Autowired
    public FrontService(Frontrepo frontrepo) {this.frontrepo=frontrepo;}

    public void saveQuiz(Frontend frontend) {
        frontrepo.save(frontend);
    }

    public List<Frontend> getAllQuizzes() {
        return frontrepo.findAll();
    }
}
