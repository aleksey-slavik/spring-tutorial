package com.globallogic.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for welcome page
 *
 * @author oleksii.slavik
 */
@Controller
public class WelcomeController {

    /**
     * Url of welcome page
     */
    private static final String WELCOME_URL = "/welcome";

    /**
     * Name of welcome page view
     */
    private static final String WELCOME_VIEW = "welcome";

    /**
     * Redirect to welcome page
     *
     * @return welcome page
     */
    @RequestMapping(path = WELCOME_URL, method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView(WELCOME_VIEW);
    }
}