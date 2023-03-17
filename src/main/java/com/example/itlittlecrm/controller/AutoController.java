package com.example.itlittlecrm.controller;

import com.example.itlittlecrm.models.Auto;
import com.example.itlittlecrm.repo.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutoController {
    @Autowired
    AutoRepository autoRepository;
    @GetMapping("/auto")
    public String autoMain(Model model) {
        Iterable<Auto> autos = autoRepository.findAll();
        model.addAttribute("autos", autos);
        return "Auto/auto-main";
    }

    @GetMapping("/auto/add")
    public String autoAdd(Auto auto, Model model) {
        return getAdd(model, auto);
    }

    private String getAdd(Model model, Auto auto) {
        model.addAttribute("auto", auto);
        return "Auto/auto-add";
    }

    @PostMapping("/auto/add")
    public String autoPostAdd(Auto auto, Model model) {
        autoRepository.save(auto);
        return "redirect:/auto";
    }

    @GetMapping("/auto/{auto}")
    public String autoDetail(Auto auto, Model model) {
        return "auto/auto-detail";
    }

    @GetMapping("/auto/{auto}/edit")
    public String autoEdit(Auto auto, Model model) {
        return "auto/auto-edit";
    }

    @PostMapping("/Auto/{id}/edit")
    public String autoPostUpdate(@ModelAttribute("Auto") Auto auto, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Auto/auto-edit";
        }
        autoRepository.save(auto);
        return "redirect:/auto";
    }

    @PostMapping("/auto/{auto}/delete")
    public String autoPostRemove(@PathVariable Auto auto, Model model) {
        autoRepository.delete(auto);
        return "redirect:/auto";
    }
}
