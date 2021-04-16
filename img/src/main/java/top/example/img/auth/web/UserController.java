package top.example.img.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.example.img.auth.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository


    @GetMapping("/pages/login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");
        return "login";
    }

}
