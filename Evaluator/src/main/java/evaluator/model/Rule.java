package evaluator.model;

import java.util.Objects;

public class Rule {
    private String object;
    private Character comparator;
    private int value;

    public Rule object(String object) {
        this.object = object;
        return this;
    }

    public String getObject() {
        return object;
    }

    public Rule comparator(Character comparator) {
        this.comparator = comparator;
        return this;
    }

    public Character getComparator() {
        return comparator;
    }

    public Rule value(int value) {
        this.value = value;
        return this;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "object='" + object + '\'' +
                ", comparator=" + comparator +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rule rule = (Rule) o;
        return value == rule.value &&
                Objects.equals(object, rule.object) &&
                Objects.equals(comparator, rule.comparator);
    }
}
