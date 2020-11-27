package spiderJava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: HomeController
 * @Author: YiHui
 * @Date: 2020-11-27 18:12
 * @Version: ing
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/root";
    }
    @GetMapping("/root")
    public String root(){
        return "test";
    }

    @PostMapping("/")
    public String postHome() {
        return "redirect:/";
    }
}
