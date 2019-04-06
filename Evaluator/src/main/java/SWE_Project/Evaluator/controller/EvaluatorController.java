package SWE_Project.Evaluator.controller;

import SWE_Project.Evaluator.model.*;
import SWE_Project.Evaluator.service.EvaluatorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/recommendation")
public class EvaluatorController {
    @RequestMapping(value = "/candidates", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getRecommendedUsers(Company company) {
        return EvaluatorService.getRecommendedUsers(company);
    }
}
