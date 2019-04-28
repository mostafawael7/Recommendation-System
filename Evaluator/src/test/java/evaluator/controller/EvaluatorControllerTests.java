package evaluator.controller;

import evaluator.model.CompaniesRequest;
import evaluator.model.Company;
import evaluator.model.User;
import evaluator.service.EvaluatorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EvaluatorController.class})
public class EvaluatorControllerTests {
    @Autowired
    private EvaluatorController evaluatorController;

    @MockBean
    private EvaluatorService evaluatorService;

    @Test
    public void getRecommendedUsersTest() {
        /**
         *  preparation data
         *  calling
         *  assertion
         */
        Company company = null;
        List<User> users = new ArrayList<>();
        users.add(new User().name("Ahmed"));
        given(evaluatorService.getRecommendedUsers(company)).willReturn(users);

        List<User> resultUsers = evaluatorController.getRecommendedUsers(company);

        Assert.assertArrayEquals(new List[]{users}, new List[]{resultUsers});
    }

    @Test
    public void getRecommendedQuizzesTest() {
        Company company = null;
        List<String> quizzes = new ArrayList<>();
        quizzes.add("c++");
        given(evaluatorService.getRecommendedQuizzes(company)).willReturn(quizzes);

        List<String> resultQuizzes = evaluatorController.getRecommendedQuizzes(company);

        Assert.assertArrayEquals(new List[]{quizzes}, new List[]{resultQuizzes});
    }

    @Test
    public void getRecommendedCompaniesTest() {
        User user = null;
        int selectionCriteria = 0;
        CompaniesRequest request = new CompaniesRequest().user(user).selectionCriteria(selectionCriteria);
        List<Company> companies = new ArrayList<>();
        companies.add(new Company().name("ACM"));
        given(evaluatorService.getRecommendedCompanies(user, selectionCriteria)).willReturn(companies);

        List<Company> resultCompanies = evaluatorController.getRecommendedCompanies(request);

        Assert.assertArrayEquals(new List[]{companies}, new List[]{resultCompanies});
    }
}