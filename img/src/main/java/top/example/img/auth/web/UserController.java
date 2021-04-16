package top.example.img.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.example.img.auth.repository.UserRepository;
import top.example.img.auth.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/pages//login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");
        return "login";
    }

    @GetMapping("/pages/signup")
    public String signUp(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");
        return "signUp";
    }

    @GetMapping("/pages/forgot-password")
    public String forgotPassword(@RequestParam(name="name", required=false, defaultValue="PASSWORD") String name, Model model){
        model.addAttribute("name", name);
        return "forgotPassword";
    }

}