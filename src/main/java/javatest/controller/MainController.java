package javatest.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {


    @GetMapping("/dashboard")
    public String abc() {
        return "dashboard";
    }

    @GetMapping("java")
    public String java() {
        return "java_tests";
    }

    @GetMapping(path = "java/{id}")
    @ResponseBody
    public String aaa(@PathVariable(value = "id") long id) {
        return String.valueOf(id);
    }

}
