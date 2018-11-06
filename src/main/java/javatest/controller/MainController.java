package javatest.controller;


import javatest.model.Answer;
import javatest.model.Question;
import javatest.model.Test;
import javatest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private TestService testService;

    @Autowired
    public MainController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @GetMapping("/java")
    public String java() {
        //TODO: hardcoded dependency
        return "java_tests";
    }

    //TODO: hardcoded dependency id
    @GetMapping(path = "/java/{id}")
    public String aaa(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("Test", testService.getTestById(id));
        return "test";
    }
}
