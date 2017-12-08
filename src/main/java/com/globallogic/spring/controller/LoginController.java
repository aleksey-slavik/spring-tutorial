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
     * Redirect to login page
     *
     * @return login page
     */
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
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
    @RequestMapping(path = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        User user = UserService.validateUser(login);

        if (user == null) {
            return new ModelAndView("login");
        } else {
            Map<String, String> model = new HashMap<String, String>();
            model.put("username", username);
            return new ModelAndView("welcome", model);
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