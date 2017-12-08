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
     * Redirect to home page
     *
     * @return home page
     */
    @RequestMapping("/")
    public ModelAndView showHomePage() {
        return new ModelAndView("index");
    }
}
