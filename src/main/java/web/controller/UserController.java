package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.DAO.UserDAO;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDAO usersDAO;

    public UserController(UserDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", usersDAO.listUsers());
        return "users/index";
    }
//    private UserService userService;
//
//    @Autowired(required = true)
//    //@Qualifier(value = "userService")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    //@RequestMapping(value = "users", method = RequestMethod.GET)
//    @GetMapping()
//    public String listUsers(Model model){
//        //model.addAttribute("user", new User());
//        model.addAttribute("listUsers", this.userService.listUsers());
//        return  "users/index";
//    }
//    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
//        public  String addUser(@ModelAttribute("user") User user){
//        if (user.getId() == 0){
//            this.userService.addUser(user);
//        }else {
//            this.userService.updateUser(user);
//        }
//        return "redirect:/users";
//    }
//
//    @RequestMapping("/remove/{id}")
//    public String removeUser(@PathVariable("id") int id){
//        this.userService.removeUser(id);
//        return "redirect:/users";
//    }
//
//    @RequestMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.userService.getUserID(id));
//        model.addAttribute("listUsers", this.userService.listUsers());
//        return "users";
//    }
//
//    @RequestMapping("userdata/{id}")
//    public String userData(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", this.userService.getUserID(id));
//        return "userdata";
//    }

}
