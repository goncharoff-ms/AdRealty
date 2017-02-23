package my.project.web;


import my.project.dao.RoleDao;
import my.project.domain.User;
import my.project.service.interfaces.SecurityService;
import my.project.service.interfaces.UserService;
import my.project.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Map;

/**
 * Created 06.02.17.
 *
 * @autor Max Goncharov
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }



    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("user") User user,
                             BindingResult bindingResult,
                             Model model) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        user.setRoleId(1L);
        userService.addUser(user);

        securityService.autoLogin(user.getLogin(), user.getPassword());

        return "redirect:/welcome";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }



    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin (Model model) {
        return "admin";
    }




    @RequestMapping("/index")
    public String home(Map<String, Object> map) {
        return "index";
    }

    @RequestMapping("/")
    public String reHome(Map<String, Object> map) {
        return "redirect:/index";
    }


}
