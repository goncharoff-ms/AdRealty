package my.project.web;

import my.project.dao.AdDao;
import my.project.domain.Ad;
import my.project.domain.Image;
import my.project.service.implementation.ImageService;
import my.project.service.interfaces.AdService;
import my.project.service.interfaces.UserService;
import org.hibernate.type.ShortType;
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
import java.sql.Date;

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

    private final ImageService imageService;

    private final UserService userService;



    @Autowired
    public AdController(UserService userService, AdService adService, ImageService imageService) {
        this.userService = userService;
        this.adService = adService;
        this.imageService = imageService;
    }


    /**
     * @return registrationAd - представление всех объявлений
     */
    @RequestMapping(method = RequestMethod.GET)
    public String allAd(Model modelMap) {
        modelMap.addAttribute("listAd", adService.sortedByIdListAd());
        return "allAd";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String formNewAd(Model model) {
        model.addAttribute("ad", new Ad());
        model.addAttribute("image", new Image());
        return "registrationAd";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String showAd(@PathVariable("id") Long id, Model model) {
        Ad nowAd = adService.findById(id);
        nowAd.setNumberShow(nowAd.getNumberShow()+1);
        model.addAttribute("ad", nowAd);
        model.addAttribute("owner", userService.findById(nowAd.getUser_id()));
        adService.updateAd(nowAd);
        return "ad";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String addNewAd(@ModelAttribute("ad") Ad ad,
                           BindingResult bindingResult,
                           @RequestParam("image") MultipartFile file,
                           Model model) throws IOException {
        logger.info("new ad: " + ad.getName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ad.setUser_id(userService.findByLogin(authentication.getName()).getId());
        ad.setNumberShow(0);
        ad.setHaveImage(0);
        ad.setDate(new Date(System.currentTimeMillis()));
        adService.addAd(ad);
        if(!file.isEmpty()) {
            imageService.addImage(file, ad.getId());
            ad.setHaveImage(1);
            adService.updateAd(ad);
        }
        return "redirect:/ad/" + ad.getId();
    }

}
