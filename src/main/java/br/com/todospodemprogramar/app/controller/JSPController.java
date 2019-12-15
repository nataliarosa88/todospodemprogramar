package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by Natalia Rosa on 08/07/19.
 */
@Controller
public class JSPController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_HOME");
        return "main";
    }

    @RequestMapping("/user")
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "main";
    }

    @PostMapping("/users")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        User u = null;

        if(userService.findByUsername(user.getUsername())!=null) {
            u = userService.findByUsername(user.getUsername());
        }else {
            u = new User();
            u.setUsername("");
        }

        if((user.getUsername().equals(u.getUsername()) && (user.getId() == 0 ))) {
            request.setAttribute("error", "Username already exists");
            request.setAttribute("mode", "MODE_REGISTER");
            return "main";
        }else {
            userService.saveMyUser(user);
            request.setAttribute("mode", "MODE_HOME");
            return "main";
        }
    }

    @GetMapping("/findall")
    public String showAllUsers(HttpServletRequest request) {
        request.setAttribute("users", userService.showAllUsers());
        request.setAttribute("mode", "ALL_USERS");
        return "main";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam int id, HttpServletRequest request) {
        userService.deleteMyUser(id);
        request.setAttribute("users", userService.showAllUsers());
        request.setAttribute("mode", "ALL_USERS");
        return "main";
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam int id,HttpServletRequest request) {
        request.setAttribute("user", userService.editUser(id).get());
        request.setAttribute("mode", "MODE_UPDATE");
        return "main";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "main";
    }

    @RequestMapping ("/findbyid")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {

        if(user.getUsername().equals("admin") && user.getUsername().equals("admin")) {
            request.setAttribute("users", userService.showAllUsers());
            request.setAttribute("mode", "MODE_ADMIN");
            return "main";
        }


        if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {

            User u = userService.findByUsername(user.getUsername());
            user.setId(u.getId());
            user.setName(u.getName());
            user.setHobby(u.getHobby());
            user.setExperience(u.getExperience());
            user.setContact(u.getContact());
            user.setPassword(u.getPassword());
            request.setAttribute("mode", "MODE_USER");
            return "main";
        }else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "main";

        }
    }

}
