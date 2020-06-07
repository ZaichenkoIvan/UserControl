package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/user")
public class UserControllerImpl {
    private static final int PAGE_SIZE = 10;
    private final UserService userService;

    @GetMapping("")
    public String showUsers(Model model, @RequestParam(value = "page", required = false) Integer page) {
        addPagination(model, page);
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("")
    public String createUser(Model model, @RequestParam(value = "page", required = false) Integer page,
                             @ModelAttribute @Valid User user) {
        userService.save(user);
        model.addAttribute("addedUser", user.getFirstName());

        addPagination(model, page);

        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(Model model, @RequestParam(value = "page", required = false) Integer page, @PathVariable Long id) {
        model.addAttribute("editId", id);
        User editUser = userService.findById(id);
        model.addAttribute("user", editUser);
        addPagination(model, page);

        return "users";
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editUser(Model model, @RequestParam(value = "page", required = false) Integer page, @PathVariable Long id,
                                 @ModelAttribute User user) {
        userService.edit(id, user);
        addPagination(model, page);

        return new ModelAndView("redirect:/user");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(Model model, @RequestParam(value = "page", required = false) Integer page, @PathVariable Long id) {
        userService.deleteById(id);
        addPagination(model, page);

        return new ModelAndView("redirect:/user");
    }

    private void addPagination(Model model, Integer current) {
        int currentPage = current == null ? 1 : current;
        Page<User> users = userService.getPageUsers(currentPage, PAGE_SIZE);
        model.addAttribute("users", users);
        model.addAttribute("currentPage", currentPage);
        int totalPages = users.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    }
}
