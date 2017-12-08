package com.globallogic.spring.controller;

import com.globallogic.spring.model.User;
import com.globallogic.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for register page
 *
 * @author oleksii.slavik
 */
@Controller
public class RegisterController {

    /**
     * Url of register page
     */
    private static final String REGISTER_URL = "/register";

    /**
     * Url of register process page
     */
    private static final String REGISTER_PROCESS_URL = "/registerProcess";

    /**
     * Name of username field in register form
     */
    private static final String USERNAME = "username";

    /**
     * Name of password field in register form
     */
    private static final String PASSWORD = "password";

    /**
     * Name of email field in register form
     */
    private static final String EMAIL = "email";

    /**
     * Key of username value for welcome page
     */
    private static final String USERNAME_KEY = "username";

    /**
     * Name of welcome page view
     */
    private static final String WELCOME_VIEW = "welcome";

    /**
     * Redirect to login page
     *
     * @return login page
     */
    @RequestMapping(path = REGISTER_URL, method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("register");
    }

    /**
     * Register user
     *
     * @param request  http request
     * @param response http response
     * @return welcome page
     */
    @RequestMapping(path = REGISTER_PROCESS_URL, method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        UserService.registerUser(user);

        Map<String, String> model = new HashMap<String, String>();
        model.put(USERNAME_KEY, username);
        return new ModelAndView(WELCOME_VIEW, model);

    }
}