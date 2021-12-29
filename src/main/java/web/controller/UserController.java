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
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserID(id));
//        return "show";
//    }
//
//    @GetMapping("/new")
//    public String newPerson(Model model){
//        model.addAttribute("user", new User());
//        return "new";
//    }
//
//    @PostMapping("/")
//    public String create(@ModelAttribute("user") User user){
//        userService.addUser(user);
//        return "redirect:/index";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.getUserID(id));
//        return "edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
//        userService.updateUser(id, user);
//        return "redirect:/index";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userService.removeUser(id);
//        return "redirect:/index";
//    }

}