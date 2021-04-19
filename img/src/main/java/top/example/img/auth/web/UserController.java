package top.example.img.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.example.img.auth.model.User;
import top.example.img.auth.repository.UserRepository;
import top.example.img.auth.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/pages")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(Model model, String error){
        model.addAttribute("userForm", new User());
        return "signUp";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model, HttpServletRequest request){
        System.out.println("UserForm " + userForm.getEmail() + userForm.getName() + userForm.getPassword() + userForm.getConfirmPassword());

        return "signUp";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(@RequestParam(name="name", required=false, defaultValue="PASSWORD") String name, Model model){
        model.addAttribute("name", name);
        return "forgotPassword";
    }

}
