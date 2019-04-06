package SWE_Project.Evaluator.model;

import java.util.List;

public class Company {
    private String name;
    private List<String> interests;
    private List<Rule> rules;

    public Company(String name, List<String> interests, List<Rule> rules) {
        this.name = name;
        this.interests = interests;
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
}
