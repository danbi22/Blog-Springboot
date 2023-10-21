package com.example.demo.web;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        LocalDateTime now = LocalDateTime.now();
        model.addAttribute("now", now);

        return "/main/index";
    }
}
