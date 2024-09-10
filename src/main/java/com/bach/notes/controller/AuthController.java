package com.bach.notes.controller;

import com.bach.notes.dto.UserDto;
import com.bach.notes.model.UserEntity;
import com.bach.notes.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid UserDto userDto,
                           BindingResult bindingResult,
                           Model model) {
        UserEntity UsernameExisting = userService.findUserByUsername(userDto.getUsername());
        if (UsernameExisting != null) {
            return "redirect:/register?fail";
        }
        UserEntity EmailExisting = userService.findUserByEmail(userDto.getEmail());
        if (EmailExisting != null) {
            return "redirect:/register?fail";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            return "register";
        }
        userService.save(userDto);
        return "redirect:/login?success";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }
}
