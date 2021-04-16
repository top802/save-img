package top.example.img.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingPagesController {

    @GetMapping("/pages/history")
    public String history(@RequestParam(name="name", required=false, defaultValue="HISTORY") String name, Model model){
        model.addAttribute("name", name);
        return "history";
    }

    @GetMapping("/pages/home")
    public String home(@RequestParam(name="name", required=false, defaultValue="HOME") String name, Model model){
        model.addAttribute("name", name);
        return "home";
    }

}
