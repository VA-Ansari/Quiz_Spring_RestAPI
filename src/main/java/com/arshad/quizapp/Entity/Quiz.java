package com.arshad.quizapp.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    //our quiz can only have three values id, title and list of questions(in separate table)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> question;
}
