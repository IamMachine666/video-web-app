package org.videosharing.controllers;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.videosharing.services.VideoService;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class MainPageController {

    private VideoService videoService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        HashMap<String, Object> model = new HashMap<>();
        model.put("videos", videoService.getAllVideoNames());
        return new ModelAndView("index_old", model);
    }

    @GetMapping(value = "/upload")
    public ModelAndView upload() {
        return new ModelAndView("index_old");
    }
}
