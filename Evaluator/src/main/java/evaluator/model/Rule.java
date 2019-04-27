package evaluator.model;

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

    public void setObject(String object) {
        this.object = object;
    }

    public Rule comparator(Character comparator) {
        this.comparator = comparator;
        return this;
    }

    public Character getComparator() {
        return comparator;
    }

    public void setComparator(Character comparator) {
        this.comparator = comparator;
    }

    public Rule value(int value) {
        this.value = value;
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
