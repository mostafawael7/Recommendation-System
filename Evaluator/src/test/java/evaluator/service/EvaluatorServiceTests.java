package evaluator.service;

import evaluator.model.Company;
import evaluator.model.Rule;
import evaluator.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EvaluatorService.class})
public class EvaluatorServiceTests {

    @Autowired
    private EvaluatorService evaluatorService;

    @Test
    public void getRecommendedUsersTest() {
        List<String> interests = new ArrayList<>(Arrays.asList("c++", "java", "problem-solving"));
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('=').value(20));
        rules.add(new Rule().object("problem-solving").comparator('<').value(100));
        Company company = new Company().name("ACM").interests(interests).rules(rules);
        List<User> users = new ArrayList<>();
        Map<String, Integer> scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 90);
        users.add(new User().name("Mona").age(21).interests(interests).scores(scores));
        scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 30);
        users.add(new User().name("Aya").age(22).interests(interests).scores(scores));

        List<User> resultUsers = evaluatorService.getRecommendedUsers(company);

        Assert.assertArrayEquals(new List[]{users}, new List[]{resultUsers});
    }

    @Test
    public void getRecommendedQuizzesTest() {
        List<String> interests = new ArrayList<>(Arrays.asList("c++", "java", "problem-solving"));
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('=').value(20));
        rules.add(new Rule().object("problem-solving").comparator('<').value(100));
        Company company = new Company().name("ACM").interests(interests).rules(rules);
        List<String> quizzes = new ArrayList<>(Arrays.asList("c++", "problem-solving"));

        List<String> resultQuizzes = evaluatorService.getRecommendedQuizzes(company);

        Assert.assertArrayEquals(new List[]{quizzes}, new List[]{resultQuizzes});
    }

    @Test
    public void getRecommendedCompaniesTest() {
        List<String> interests = new ArrayList<>(Arrays.asList("c++", "java", "problem-solving"));
        Map<String, Integer> scores = new HashMap<>();
        scores.put("c++", 30);
        scores.put("java", 20);
        scores.put("problem-solving", 90);
        User user = new User().name("Mona").age(21).interests(interests).scores(scores);
        List<Company> companies = new ArrayList<>();
        interests = new ArrayList<>(Arrays.asList("c++", "java", "problem-solving"));
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('<').value(30));
        rules.add(new Rule().object("problem-solving").comparator('=').value(90));
        companies.add(new Company().name("Company3").interests(interests).rules(rules));

        List<Company> resultCompanies = evaluatorService.getRecommendedCompanies(user, 2);

        Assert.assertArrayEquals(new List[]{companies}, new List[]{resultCompanies});

        companies = new ArrayList<>();
        interests = new ArrayList<>(Arrays.asList("c++", "java"));
        rules = new ArrayList<>();
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('>').value(30));
        companies.add(new Company().name("Company2").interests(interests).rules(rules));
        interests = new ArrayList<>(Arrays.asList("c++", "java", "problem-solving"));
        rules = new ArrayList<>();
        rules.add(new Rule().object("c++").comparator('>').value(20));
        rules.add(new Rule().object("java").comparator('<').value(30));
        rules.add(new Rule().object("problem-solving").comparator('=').value(90));
        companies.add(new Company().name("Company3").interests(interests).rules(rules));

        resultCompanies = evaluatorService.getRecommendedCompanies(user, 1);

        Assert.assertArrayEquals(new List[]{companies}, new List[]{resultCompanies});
    }

}
