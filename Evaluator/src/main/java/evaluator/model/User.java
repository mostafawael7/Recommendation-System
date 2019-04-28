package evaluator.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private List<String> interests;
    private Map<String, Integer> scores;

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public User interests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public User scores(Map<String, Integer> scores) {
        this.scores = scores;
        return this;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", interests=" + interests +
                ", scores=" + scores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(interests, user.interests) &&
                Objects.equals(scores, user.scores);
    }
}
