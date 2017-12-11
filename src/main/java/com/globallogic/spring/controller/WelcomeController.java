package com.globallogic.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller for welcome page
 *
 * @author oleksii.slavik
 */
@Controller
public class WelcomeController extends AbstractController {

    /**
     * Name of welcome page view
     */
    private static final String WELCOME_VIEW = "welcome";

    /**
     * Redirect to welcome page
     *
     * @return welcome page
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        return new ModelAndView(WELCOME_VIEW);
    }
}