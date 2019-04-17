package SWE_Project.Evaluator.model;

import java.util.List;
import java.util.Map;

// lombok
public class User {
    private String name;
    private int age;
    private List<String> interests;
    private Map<String, Integer> scores;

    public User name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User interests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public User scores(Map<String, Integer> scores) {
        this.scores = scores;
        return this;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }
}
