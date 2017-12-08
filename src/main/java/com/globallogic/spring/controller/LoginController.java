package com.globallogic.spring.controller;

import com.globallogic.spring.model.Login;
import com.globallogic.spring.model.User;
import com.globallogic.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller for login page
 *
 * @author oleksii.slavik
 */
@Controller
public class LoginController {

    /**
     * Url of login page
     */
    private static final String LOGIN_URL = "/login";

    /**
     * Url of login process page
     */
    private static final String LOGIN_PROCESS_URL = "/loginProcess";

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
     * Redirect to login page
     *
     * @return login page
     */
    @RequestMapping(path = LOGIN_URL, method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(LOGIN_VIEW);
    }

    /**
     * Validate input data in login page.
     * Redirect to welcome page if valid user.
     * Redirect to login page in otherwise.
     *
     * @param request  http request
     * @param response http response
     * @return redirect page
     */
    @RequestMapping(path = LOGIN_PROCESS_URL, method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

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

    /**
     * Redirecting to test page
     *
     * @return test page
     */
    @RequestMapping(path = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test() {
        return "Success";
    }
}