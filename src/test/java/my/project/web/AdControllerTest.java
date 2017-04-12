package my.project.web;

import my.project.service.implementation.ImageService;
import my.project.service.interfaces.AdService;
import my.project.service.interfaces.UserService;
import my.project.validator.AdValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import javax.swing.text.html.FormSubmitEvent;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by max on 12.04.17.
 *
 * @autor Max Goncharov
 */

public class AdControllerTest {

    @Mock
    private AdService adService;

    @Mock
    private UserService userService;

    @Mock
    private ImageService imageService;


    private AdValidator adValidator = new AdValidator();

    private AdController adController;

    @Before
    public void setUp() throws Exception {
        adController = new AdController(userService, adService, imageService, adValidator);
    }

    @Test
    public void allAd() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adController).build();
        mockMvc.perform(post("/ad").param(new Model(), "john").param("password", "secret"));
    }

    @Test
    public void formNewAd() throws Exception {

    }

    @Test
    public void showAd() throws Exception {

    }

    @Test
    public void addNewAd() throws Exception {

    }

}