package com.globallogic.spring.controller;

import com.globallogic.spring.model.User;
import com.globallogic.spring.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for register process
 *
 * @author oleksii.slavik
 */
public class RegisterProcessController extends AbstractController {

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
     * Register user
     *
     * @param httpServletRequest  http request
     * @param httpServletResponse http response
     * @return welcome page
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String username = httpServletRequest.getParameter(USERNAME);
        String password = httpServletRequest.getParameter(PASSWORD);
        String email = httpServletRequest.getParameter(EMAIL);

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
