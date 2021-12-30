package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.models.User;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.index());
        System.out.println(new User());
        return "users";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        if (user.getId() == 0) {
            userService.addUser(user);
        } else {
            userService.updateUser(user.getId(), user);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserID(id));
        model.addAttribute("index", userService.index());
        return "edit";
    }

    // @PatchMapping("/{id}")
    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    //@DeleteMapping("/remove/{id}")
    @RequestMapping(value = "/remove/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("userdata/{id}")
    public String userdata(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserID(id));
        return "userdata";
    }

}