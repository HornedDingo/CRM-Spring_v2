package com.example.itlittlecrm.controller;

import com.example.itlittlecrm.models.Saler;
import com.example.itlittlecrm.repo.PurchaseRepository;
import com.example.itlittlecrm.repo.SalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class SalerContoller {
    @Autowired
    SalerRepository salerRepository;
    
    @Autowired
    PurchaseRepository purchaseRepository;
    
    @GetMapping("/saler")
    public String salerMain(Model  model) {
        Iterable<Saler> salers = salerRepository.findAll();
        model.addAttribute("salers", salers);
        return "Saler/saler-main";
    }

    @GetMapping("/saler/add")
    public String salerAdd(Saler saler, Model model) {
        return getAdd(model, saler);
    }

    private String getAdd(Model model, Saler saler) {
        model.addAttribute("saler", saler);
        return "Saler/saler-add";
    }

    @PostMapping("/saler/add")
    public String salerPostAdd(Saler saler, Model model) {
        salerRepository.save(saler);
        return "redirect:/saler";
    }

    @GetMapping("/saler/{saler}")
    public String salerDetail(Saler saler, Model model) {
        return "saler/saler-detail";
    }

    @GetMapping("/saler/{saler}/edit")
    public String salerEdit(Saler saler, Model model) {
        return "saler/saler-edit";
    }

    @PostMapping("/Saler/{id}/edit")
    public String salerPostUpdate(@ModelAttribute("Saler") Saler saler, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Saler/saler-edit";
        }
        salerRepository.save(saler);
        return "redirect:/saler";
    }

    @PostMapping("/saler/{id}/delete")
    public String salerPostDelete(@ModelAttribute("Saler") Saler saler) {
        salerRepository.delete(saler);
        return "redirect:/saler";
    }
}
