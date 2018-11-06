package javatest.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private int level;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    public Test() {
    }

    public Test(int level) {
        this.level = level;
    }

    public Test(int level, List<Question> questions) {
        this.level = level;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
