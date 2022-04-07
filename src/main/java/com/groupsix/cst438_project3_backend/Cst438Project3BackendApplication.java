package com.groupsix.cst438_project3_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Cst438Project3BackendApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Cst438Project3BackendApplication.class, args);
    }
}
