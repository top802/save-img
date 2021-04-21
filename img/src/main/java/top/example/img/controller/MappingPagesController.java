package top.example.img.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pages")
public class MappingPagesController {

    @GetMapping("/history")
    public String history(@RequestParam(name="name", required=false, defaultValue="HISTORY") String name, Model model){
        // TODO get all saving images

        model.addAttribute("name", name);
        return "history";
    }

    @GetMapping("/home")
    public String home(@RequestParam(name="name", required=false, defaultValue="HOME") String name, Model model){
        model.addAttribute("name", name);
        return "home";
    }

}
