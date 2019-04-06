package SWE_Project.Evaluator.model;

public class Rule {
    private String object;
    private Character comparator;
    private int value;

    public Rule(String object, Character comparator, int value) {
        this.object = object;
        this.comparator = comparator;
        this.value = value;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Character getComparator() {
        return comparator;
    }

    public void setComparator(Character comparator) {
        this.comparator = comparator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
