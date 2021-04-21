package top.example.img.auth.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.example.img.auth.jwt.JwtProvider;
import top.example.img.auth.model.User;
import top.example.img.auth.repository.UserRepository;
import top.example.img.auth.service.UserService;
import top.example.img.auth.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequestMapping("/pages")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/login")
    public String login(Model model, String error){
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid");
        return "login";
    }

//    @PostMapping("/login")
//    public AuthResponse auth(@RequestBody AuthRequest request) {
//        User userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
//        String token = jwtProvider.generateToken(userEntity.getLogin());
//        return new AuthResponse(token);
//    }

    @GetMapping("/signup")
    public String signUp(Model model, String error){
        model.addAttribute("userForm", new User());
        return "signUp";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model, HttpServletRequest request){

        System.out.println("UserForm " + userForm.getEmail() + userForm.getName() + userForm.getPassword() + userForm.getConfirmPassword());

        userValidator.validate(userForm, bindingResult);


        User isUserExists = userService.findByEmail(userForm.getEmail());
        if (isUserExists != null){
            model.addAttribute("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided");
            bindingResult.reject("email");
            return "signUp";
        }

        if (bindingResult.hasErrors()) {
            System.out.println("Errors " + bindingResult.hasErrors());
            return "signUp";
        } else {


            userForm.setConfirmationToken(JwtProvider.generateToken(userForm.getEmail()));

            userService.save(userForm);

//            String appUrl = request.getScheme() + "://" + request.getServerName();
//
//            SimpleMailMessage registrationEmail = new SimpleMailMessage();
//            registrationEmail.setTo(userForm.getEmail());
//            registrationEmail.setSubject("Registration Confirmation");
//            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
//                    + appUrl + "/confirm?token=" + userForm.getConfirmationToken());
//            registrationEmail.setFrom("noreply@domain.com");
//            emailService.sendEmail(registrationEmail);
//            model.addAttribute("confirmationMessage", "A confirmation e-mail has been sent to " + userForm.getEmail());
        }


        return "redirect:/pages/login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(@RequestParam(name="name", required=false, defaultValue="PASSWORD") String name, Model model){
        model.addAttribute("name", name);
        return "forgotPassword";
    }

}
