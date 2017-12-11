package com.globallogic.spring.controller;

import com.globallogic.spring.model.Login;
import com.globallogic.spring.model.User;
import com.globallogic.spring.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for login process
 *
 * @author oleksii.slavik
 */
public class LoginProcessController extends AbstractController {

    /**
     * Name of username field in login form
     */
    private static final String USERNAME = "username";

    /**
     * Name of password field in login form
     */
    private static final String PASSWORD = "password";

    /**
     * Name of login page view
     */
    private static final String LOGIN_VIEW = "login";

    /**
     * Name of welcome page view
     */
    private static final String WELCOME_VIEW = "welcome";

    /**
     * Key of message value for login page
     */
    private static final String MESSAGE_KEY = "message";

    /**
     * Key of username value for welcome page
     */
    private static final String USERNAME_KEY = "username";

    /**
     * Message for login page
     */
    private static final String MESSAGE = "Username or password is wrong!";

    /**
     * Validate input data in login page.
     * Redirect to welcome page if valid user.
     * Redirect to login page in otherwise.
     *
     * @param httpServletRequest  http request
     * @param httpServletResponse http response
     * @return redirect page
     */
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String username = httpServletRequest.getParameter(USERNAME);
        String password = httpServletRequest.getParameter(PASSWORD);

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        User user = UserService.validateUser(login);
        Map<String, String> model = new HashMap<String, String>();

        if (user == null) {
            model.put(MESSAGE_KEY, MESSAGE);
            return new ModelAndView(LOGIN_VIEW, model);
        } else {
            model.put(USERNAME_KEY, username);
            return new ModelAndView(WELCOME_VIEW, model);
        }
    }
}
