package my.project.web;

import my.project.domain.Ad;
import my.project.domain.Image;
import my.project.service.implementation.ImageService;
import my.project.service.interfaces.AdService;
import my.project.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created 24.02.17.
 * Контроллер для объявлений
 * @autor Max Goncharov
 */
@Controller
@RequestMapping("/ad")
public class AdController {

    private static Logger logger = LoggerFactory.getLogger(AdController.class);

    private final AdService adService;

    private final UserService userService;



    @Autowired
    public AdController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }


    /**
     * @return registrationAd - представление всех объявлений
     */
    @RequestMapping(method = RequestMethod.GET)
    public String allAd(Model modelMap) {
        modelMap.addAttribute("listAd", adService.sortedByIdListAd());
        return "allAd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String formNewAd(Model model) {
        model.addAttribute("ad", new Ad());
        return "registrationAd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewAd(@ModelAttribute("ad") Ad ad,
                           BindingResult bindingResult,
                           Model model) throws IOException {
        logger.info("new ad: " + ad.getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ad.setUser_id(userService.findByLogin(authentication.getName()).getId());
        ad.setNumberShow(0);
        adService.addAd(ad);
        model.addAttribute("adId", ad.getId());
        model.addAttribute("image", new Image());
        return "addImageForAd";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showAd(@PathVariable("id") String id, Model model) {
        Ad nowAd = adService.findById(Long.valueOf(id));
        nowAd.setNumberShow(nowAd.getNumberShow()+1);
        model.addAttribute("ad", nowAd);
        model.addAttribute("owner", userService.findById(nowAd.getUser_id()));
        adService.updateAd(nowAd);
        return "ad";
    }

}
