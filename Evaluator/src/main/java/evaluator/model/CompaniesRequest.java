package evaluator.model;

public class CompaniesRequest {
    private User user;
    private int selectionCriteria;

    public CompaniesRequest user(User user) {
        this.user = user;
        return this;
    }

    public User getUser() {
        return user;
    }

    public CompaniesRequest selectionCriteria(int selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
        return this;
    }

    public int getSelectionCriteria() {
        return selectionCriteria;
    }
}
