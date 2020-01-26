package br.com.todospodemprogramar.app.controller;

import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.services.JSPService;
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

    private static final String  MODE = "mode";
    private static final String USERS = "users";
    private static final String ERROR = "erro";

    @Autowired
    JSPService jspService;

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        request.setAttribute(MODE, "MODE_HOME");
        return "main";
    }

    @RequestMapping("/user")
    public String registration(HttpServletRequest request) {
        request.setAttribute(MODE, "MODE_REGISTER");
        return "main";
    }

    @PostMapping("/users")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        User u = null;

        if(jspService.findByUsername(user.getUsername())!=null) {
            u = jspService.findByUsername(user.getUsername());
        }else {
            u = new User();
            u.setUsername("");
        }

        if((user.getUsername().equals(u.getUsername()) && (user.getId() == 0 ))) {
            request.setAttribute(ERROR, "Username already exists");
            request.setAttribute(MODE, "MODE_REGISTER");
            return "main";
        }else {
            jspService.saveMyUser(user);
            request.setAttribute(MODE, "MODE_HOME");
            return "main";
        }
    }

    @GetMapping("/findall")
    public String showAllUsers(HttpServletRequest request) {
        request.setAttribute(USERS, jspService.showAllUsers());
        request.setAttribute(MODE, "ALL_USERS");
        return "main";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam int id, HttpServletRequest request) {
        jspService.deleteMyUser(id);
        request.setAttribute(USERS, jspService.showAllUsers());
        request.setAttribute(MODE, "ALL_USERS");
        return "main";
    }

    @RequestMapping("/edit")
    public String editUser(@RequestParam int id,HttpServletRequest request) {
        User user = jspService.findById(id);
        request.setAttribute("user", user);
        request.setAttribute(MODE, "MODE_UPDATE");
        return "main";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute(MODE, "MODE_LOGIN");
        return "main";
    }

    @RequestMapping ("/findbyid")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {

        if(user.getUsername().equals("admin") && user.getUsername().equals("admin")) {
            request.setAttribute(USERS, jspService.showAllUsers());
            request.setAttribute(MODE, "MODE_ADMIN");
            return "main";
        }


        if(jspService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {

            User u = jspService.findByUsername(user.getUsername());
            user.setId(u.getId());
            user.setName(u.getName());
            user.setHobby(u.getHobby());
            user.setExperience(u.getExperience());
            user.setContact(u.getContact());
            user.setPassword(u.getPassword());
            request.setAttribute("mode", "MODE_USER");
            return "main";
        }else {
            request.setAttribute(ERROR, "Invalid Username or Password");
            request.setAttribute(MODE, "MODE_LOGIN");
            return "main";

        }
    }

}
