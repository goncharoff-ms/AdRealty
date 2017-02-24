package my.project.web;

import my.project.domain.Ad;
import my.project.domain.User;
import my.project.service.interfaces.AdService;
import my.project.service.interfaces.UserService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Action;

/**
 * Created 24.02.17.
 * Контроллер для объявлений
 * @autor Max Goncharov
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private UserService userService;


    /**
     * @return registrationAd - представление всех объявлений
     */
    @RequestMapping(method = RequestMethod.GET)
    public String allAd(Model modelMap) {
        modelMap.addAttribute("listAd", adService.listAd());
        return "ads";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String formNewAd(Model model) {
        model.addAttribute("ad", new Ad());
        return "registrationAd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewAd(@ModelAttribute("ad") Ad ad,
                           BindingResult bindingResult,
                           Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ad.setUser_id(userService.findByLogin(authentication.getName()).getId());

        adService.addAd(ad);

        return "redirect:/ad";
    }
}
