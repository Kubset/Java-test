package javatest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String description;

    @Column(columnDefinition = "TEXT")
    private String codeSnippet;
    private int points;

    @ManyToOne(targetEntity = Test.class)
    private Test test;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question() {
    }

    public Question(String description, String codeSnippet, int points, Test test) {
        this.description = description;
        this.codeSnippet = codeSnippet;
        this.points = points;
        this.test = test;
    }

    public Question(String description, String codeSnippet, int points, Test test, List<Answer> answers) {
        this.description = description;
        this.codeSnippet = codeSnippet;
        this.points = points;
        this.test = test;
        this.answers = answers;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @JsonIgnore
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

}
