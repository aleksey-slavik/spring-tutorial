package com.globallogic.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for home page
 *
 * @author oleksii.slavik
 */
@Controller
public class HomeController {

    /**
     * Default url of home page
     */
    private static final String SIMPLE_HOME_URL = "/";

    /**
     * Url of home page
     */
    private static final String HOME_URL = "/home";

    /**
     * Name of home page view
     */
    private static final String HOME_VIEW = "home";

    /**
     * Redirect to home page
     *
     * @return home page
     */
    @RequestMapping({SIMPLE_HOME_URL, HOME_URL})
    public ModelAndView showHomePage() {
        return new ModelAndView(HOME_VIEW);
    }
}
