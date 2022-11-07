package org.videosharing.controllers;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@AllArgsConstructor
public class MainPageController {
    @GetMapping(value = "/")
    public ModelAndView index(Model model) {
        return new ModelAndView("index");
    }
}
