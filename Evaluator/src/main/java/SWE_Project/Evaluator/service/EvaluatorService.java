package SWE_Project.Evaluator.service;

import SWE_Project.Evaluator.model.Company;
import SWE_Project.Evaluator.model.Rule;
import SWE_Project.Evaluator.model.User;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EvaluatorService {

    // TODO request the current users of the system from an API.
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
        scores.put("problem-solving", 90);
        users.add(new User().name("Mona").age(21).interests(interests).scores(scores));
        interests = new ArrayList<>();
        interests.add("c++");
        interests.add("java");
        interests.add("problem-solving");
        scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 30);
        users.add(new User().name("Aya").age(22).interests(interests).scores(scores));
        return users;
    }

    private boolean isMatch(User user, Company company) {
        List<String> companyInterests = company.getInterests();
        List<String> userInterests = user.getInterests();
        for (int i = 0; i < companyInterests.size(); i++) {
            if (userInterests.indexOf(companyInterests.get(i)) == -1)
                return false;
        }
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
        Collections.sort(temp, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
            }
        });
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
            if (isMatch(user, company))
                recommendedUsers.add(user);
        }
        return sort(recommendedUsers);
    }

    // TODO request the current quizzes of the system from an API.
    private List<String> getCurrentQuizzes() {
        List<String> quizzes = new ArrayList<>();
        quizzes.add("c++");
        quizzes.add("problem-solving");
        return quizzes;
    }

    public List<String> getRecommendedQuizzes(Company company) {
        List<String> recommendedQuizzes = new ArrayList<>();
        List<String> currentQuizzes = getCurrentQuizzes();
        List<Rule> companyRules = company.getRules();
        for (int i = 0; i < companyRules.size(); i++) {
            String skill = companyRules.get(i).getObject();
            if (currentQuizzes.indexOf(skill) != -1)
                recommendedQuizzes.add(skill);
        }
        return recommendedQuizzes;
    }


}