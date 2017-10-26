package tequila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import tequila.entity.User;
import tequila.service.UserService;


@Controller
@RequestMapping("/")

public class UserController{

    @Autowired
    public UserService userService;


    @GetMapping("/page")
    public String page(){
        return "page";
    }

    @GetMapping("/users")
    public String getAllUSers(Model model){
        model.addAttribute("users", userService.findAll());
        return "usersList";

    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/addUser")
    public String createUserPage(){
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/user/"+ user.getId();
    }


    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute(userService.getById(id));
        return  "editUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return  "redirect:/users";
    }



//    @RequestMapping(value="/page", method=RequestMethod.GET)
//    public String page(Model model) {
//        model.addAttribute("page");
//        return "page";
//    }

    }




