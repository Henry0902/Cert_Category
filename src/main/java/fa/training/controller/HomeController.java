package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping(value = { "", "/", "/index", "/home"})
    public String homePageUI(Model model){
        return "index";
    }
}
