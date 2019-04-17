package SWE_Project.Evaluator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// java reflections

public class Company {
    // @JsonProperty("name")
    private String name;
    private List<String> interests;
    private List<Rule> rules;

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Company interests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Company rules(List<Rule> rules) {
        this.rules = rules;
        return this;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
