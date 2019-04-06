package SWE_Project.Evaluator.model;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private List<String> interests;
    private Map<String, Integer> scores;

    public User(String name, int age, List<String> interests, Map<String, Integer> scores) {
        this.name = name;
        this.age = age;
        this.interests = interests;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }
}
