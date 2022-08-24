package web.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.project.entity.User;
import web.project.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService (UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public String allUsers(Model model){
        List<User>all=userService.usersList();
        model.addAttribute("users", all);
        return "users";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable ("id")int id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "one-of-users";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id, Model model){
        model.addAttribute("user",userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute ("user") User user){
        userService.deleteUser(user);
        return "redirect:/";

    }


}
