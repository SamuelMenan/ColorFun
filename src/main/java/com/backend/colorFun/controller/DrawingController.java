package com.backend.colorFun.controller;

import com.backend.colorFun.model.Drawing;
import com.backend.colorFun.service.DrawingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DrawingController {

    private final DrawingService drawingService;

    public DrawingController(DrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        Drawing d = drawingService.get("easy", false, false);
        model.addAttribute("drawing", d);
        model.addAttribute("selectedLevel", "easy");
        model.addAttribute("guide", false);
        model.addAttribute("glow", false);
        return "index";
    }

    @GetMapping("/drawing")
    public String drawing(@RequestParam(defaultValue = "easy") String level,
                          @RequestParam(defaultValue = "false") boolean guide,
                          @RequestParam(defaultValue = "false") boolean glow,
                          Model model) {
        Drawing d = drawingService.get(level, guide, glow);
        model.addAttribute("drawing", d);
        model.addAttribute("selectedLevel", level);
        model.addAttribute("guide", guide);
        model.addAttribute("glow", glow);
        return "index";
    }
}
