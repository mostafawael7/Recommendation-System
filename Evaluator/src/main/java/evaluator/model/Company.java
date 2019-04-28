package evaluator.model;

import java.util.List;
import java.util.Objects;

public class Company {
    private String name;
    private List<String> interests;
    private List<Rule> rules;

    public Company name(String name) {
        this.name = name;
        return this;
    }

    public Company interests(List<String> interests) {
        this.interests = interests;
        return this;
    }

    public List<String> getInterests() {
        return interests;
    }

    public Company rules(List<Rule> rules) {
        this.rules = rules;
        return this;
    }

    public List<Rule> getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", interests=" + interests +
                ", rules=" + rules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) &&
                Objects.equals(interests, company.interests) &&
                Objects.equals(rules, company.rules);
    }
}
