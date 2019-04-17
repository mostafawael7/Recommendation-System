package SWE_Project.Evaluator.controller;

import SWE_Project.Evaluator.service.EvaluatorService;
import SWE_Project.Evaluator.model.Company;
import SWE_Project.Evaluator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
public class EvaluatorController {

    @Autowired
    private EvaluatorService evaluatorService;

    @RequestMapping(value = "/candidates", method = RequestMethod.POST)
    public List<User> getRecommendedUsers(@RequestBody Company company) {
        return evaluatorService.getRecommendedUsers(company);
    }
}
