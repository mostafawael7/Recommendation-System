package evaluator.controller;

import evaluator.model.CompaniesRequest;
import evaluator.model.Company;
import evaluator.model.User;
import evaluator.service.EvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
public class EvaluatorController {

    @Autowired
    private EvaluatorService evaluatorService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public List<User> getRecommendedUsers(@RequestBody Company company) {
        return evaluatorService.getRecommendedUsers(company);
    }

    @RequestMapping(value = "/quizzes", method = RequestMethod.POST)
    public List<String> getRecommendedQuizzes(@RequestBody Company company) {
        return evaluatorService.getRecommendedQuizzes(company);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    public List<Company> getRecommendedCompanies(@RequestBody CompaniesRequest request) {
        return evaluatorService.getRecommendedCompanies(request.getUser(), request.getSelectionCriteria());
    }

}
