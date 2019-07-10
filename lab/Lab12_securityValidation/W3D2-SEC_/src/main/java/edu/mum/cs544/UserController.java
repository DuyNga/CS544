package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
//    @Lazy
    private UserService userService;
    @Autowired
//    @Lazy
    private AuthorityService authorityService;

//    @GetMapping("/")
//    public String redirectRoot() {
//        return "redirect:/users";
//    }
//
//    @GetMapping("/users")
//    public String getAll(Model model) {
//        model.addAttribute("users", userService.getAll());
//        return "userList";
//    }

    @ModelAttribute("authorities")
    public List<Authority> getAuthorities( ){
        return authorityService.getAll();
    }

    @GetMapping("/usersAdd")
    public String viewAdd(@ModelAttribute User user, Model model) {
        model.addAttribute("msg", "Add");
        return "addUser";
    }

//    @GetMapping("/users/{id}")
//    public String get(@PathVariable(required = false) Integer id, @ModelAttribute User user, Model model) {
//        System.out.println("1");
//        model.addAttribute("user", userService.get(id));
//        System.out.println("2");
//        model.addAttribute("msg", "Update");
//        System.out.println("3");
//        return "userDetail";
//    }

    @PostMapping({"/usersAdd"})
    public String update(@ModelAttribute User user) {
        userService.update(user); // user.id already set by binding
        return "redirect:/cars";
    }

//    @PostMapping(value = "/users/delete")
//    public String delete(int userId) {
//        userService.delete(userId);
//        return "redirect:/users";
//    }
}
