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
     * Redirect to welcome page
     *
     * @return welcome page
     */
    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }
}