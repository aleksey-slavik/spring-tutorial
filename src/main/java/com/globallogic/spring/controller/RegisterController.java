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
     * Redirect to login page
     *
     * @return login page
     */
    @RequestMapping(path = "/register", method = RequestMethod.GET)
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
    @RequestMapping(path = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        UserService.registerUser(user);

        Map<String, String> model = new HashMap<String, String>();
        model.put("username", username);
        return new ModelAndView("welcome", model);

    }
}