package evaluator.model;

public class CompaniesRequest {
    private User user;
    private int selectionCriteria;

    public User getUser() {
        return user;
    }

    public int getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSelectionCriteria(int selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }
}
