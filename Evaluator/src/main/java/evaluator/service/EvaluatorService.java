package evaluator.service;

import evaluator.model.Company;
import evaluator.model.Rule;
import evaluator.model.User;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluatorService {

    /**
     * TODO: request the current users of the system from an API.
     */
    private List<User> getCurrentUsers() {
        List<User> users = new ArrayList<>();
        List<String> interests = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();
        interests.add("c++");
        interests.add("java");
        scores.put("c++", 30);
        scores.put("java", 20);
        users.add(new User().name("Ahmed").age(25).interests(interests).scores(scores));
        interests = new ArrayList<>();
        interests.add("c++");
        interests.add("java");
        interests.add("problem-solving");
        scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 30);
        users.add(new User().name("Aya").age(22).interests(interests).scores(scores));
        interests = new ArrayList<>();
        interests.add("c++");
        interests.add("java");
        interests.add("problem-solving");
        scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 90);
        users.add(new User().name("Mona").age(21).interests(interests).scores(scores));
        return users;
    }

    /**
     * TODO: request the current quizzes of the system from an API.
     */
    private List<String> getCurrentQuizzes() {
        List<String> quizzes = new ArrayList<>();
        quizzes.add("c++");
        quizzes.add("problem-solving");
        return quizzes;
    }

    /**
     * TODO: request the current companies of the system from an API.
     */
    private List<Company> getCurrentCompanies() {
        List<Company> companies = new ArrayList<>();
        List<String> interests = new ArrayList<>();
        List<Rule> rules = new ArrayList<>();
        interests.add("c++");
        interests.add("ruby");
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("ruby").comparator('<').value(30));
        companies.add(new Company().name("Company1").interests(interests).rules(rules));
        interests = new ArrayList<>();
        rules = new ArrayList<>();
        interests.add("c++");
        interests.add("java");
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('>').value(30));
        companies.add(new Company().name("Company2").interests(interests).rules(rules));
        interests = new ArrayList<>();
        rules = new ArrayList<>();
        interests.add("c++");
        interests.add("java");
        interests.add("problem-solving");
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('<').value(30));
        rules.add(new Rule().object("problem-solving").comparator('=').value(90));
        companies.add(new Company().name("Company3").interests(interests).rules(rules));
        return companies;
    }

    private boolean isInterestsMatch(User user, Company company) {
        List<String> companyInterests = company.getInterests();
        List<String> userInterests = user.getInterests();
        for (int i = 0; i < companyInterests.size(); i++) {
            if (userInterests.indexOf(companyInterests.get(i)) == -1)
                return false;
        }
        return true;
    }

    private boolean isRulesMatch(User user, Company company) {
        List<Rule> rules = company.getRules();
        Map<String, Integer> scores = user.getScores();
        for (int i = 0; i < rules.size(); i++) {
            Rule rule = rules.get(i);
            if (rule.getComparator() == '>') {
                if (scores.get(rule.getObject()) <= rule.getValue())
                    return false;
            } else if (rule.getComparator() == '<') {
                if (scores.get(rule.getObject()) >= rule.getValue())
                    return false;
            } else {
                if (scores.get(rule.getObject()) != rule.getValue())
                    return false;
            }
        }
        return true;
    }

    private boolean isMatch(User user, Company company) {
        return isInterestsMatch(user, company) && isRulesMatch(user, company);
    }

    private List<User> sort(List<User> users) {
        List<Pair<Integer, Integer>> temp = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            int totalScores = 0;
            for (Map.Entry<String, Integer> entry : user.getScores().entrySet()) {
                totalScores += entry.getValue();
            }
            temp.add(new Pair<>(totalScores, i));
        }
        Collections.sort(temp, (p1, p2) -> p2.getKey() - p1.getKey());
        List<User> sortedUsers = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            int index = temp.get(i).getValue();
            sortedUsers.add(users.get(index));
        }
        return sortedUsers;
    }

    public List<User> getRecommendedUsers(Company company) {
        List<User> recommendedUsers = new ArrayList<>();
        List<User> currentUsers = getCurrentUsers();
        for (int i = 0; i < currentUsers.size(); i++) {
            User user = currentUsers.get(i);
            if (isMatch(user, company)) {
                recommendedUsers.add(user);
            }
        }
        return sort(recommendedUsers);
    }

    public List<String> getRecommendedQuizzes(Company company) {
        List<String> recommendedQuizzes = new ArrayList<>();
        List<String> currentQuizzes = getCurrentQuizzes();
        List<Rule> companyRules = company.getRules();
        for (int i = 0; i < companyRules.size(); i++) {
            String skill = companyRules.get(i).getObject();
            if (currentQuizzes.indexOf(skill) != -1) {
                recommendedQuizzes.add(skill);
            }
        }
        return recommendedQuizzes;
    }

    public List<Company> getRecommendedCompanies(User user, int selectionCriteria) {
        List<Company> recommendedCompanies = new ArrayList<>();
        List<Company> currentCompanies = getCurrentCompanies();
        for (int i = 0; i < currentCompanies.size(); i++) {
            Company company = currentCompanies.get(i);
            if ((selectionCriteria == 1 && isInterestsMatch(user, company))
                    || (selectionCriteria == 2 && isMatch(user, company))) {
                recommendedCompanies.add(company);
            }
        }
        return recommendedCompanies;
    }
}