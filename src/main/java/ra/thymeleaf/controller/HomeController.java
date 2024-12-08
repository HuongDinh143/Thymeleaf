package ra.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

@Controller
public class HomeController {
    @RequestMapping
    public String home(Model model) {
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","",""};
        model.addAttribute("name", "Hồ Xuân Hùng");
        model.addAttribute("list", Arrays.asList(1,2,4,5,7,8));
        model.addAttribute("age", new Random().nextInt(50));
        model.addAttribute("day", days[new Random().nextInt(days.length)]);
        model.addAttribute("now", LocalDateTime.now());
        return "index";
    }
}
