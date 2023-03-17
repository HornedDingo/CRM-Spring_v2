package com.example.itlittlecrm.controller;

import com.example.itlittlecrm.models.*;
import com.example.itlittlecrm.repo.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.itlittlecrm.repo.SetsRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SetsController {
    @Autowired
    SetsRepository setsRepository;
    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/sets")
    public String setsMain(Model model) {
        Iterable<Sets> sets = setsRepository.findAll();
        Iterable<Products> products = productsRepository.findAll();
        model.addAttribute("products", products);
        model.addAttribute("sets", sets);
        return "Sets/sets-main";
    }

    @GetMapping("/sets/add")
    public String setsAdd(Sets sets, Model model) {
        return getString(model);
    }

    private String getString(Model model) {
        Iterable<Sets> setss = setsRepository.findAll();
        Iterable<Products> productss = productsRepository.findAll();
        model.addAttribute("setss", setss);
        model.addAttribute("productss", productss);
        return "Sets/sets-add";
    }

    @PostMapping("/sets/add")
    public String setsPostAdd(@ModelAttribute("sets") @Valid Sets sets, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getString(model);
        }
        setsRepository.save(sets);
        return "redirect:/sets";
    }

    private Boolean setsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!setsRepository.existsById(id)) {
            return true;
        }
        Sets sets = setsRepository.findById(id).orElseThrow();
        model.addAttribute("sets", sets);
        return false;
    }

    @GetMapping("/sets/{id}")
    public String setsDetail(@PathVariable(value = "id") long id, Model model) {
        if (setsDetails(id, model)) {
            return "redirect:/sets";
        }
        return "Sets/sets-details";
    }

    @GetMapping("/sets/{sets}/edit")
    public String setsEdit(Model model, Sets sets) {
        Iterable<Products> productss = productsRepository.findAll();
        model.addAttribute("productss", productss);
        return "Sets/sets-edit";
    }

    @PostMapping("/sets/{id}/edit")
    public String setsPostEdit(@ModelAttribute("sets") @Valid Sets sets, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "Sets/sets-edit";
        }
        setsRepository.save(sets);
        return "redirect:/sets";
    }

    @PostMapping("/sets/{id}/remove")
    public String setsPostDelete(@PathVariable(value = "id") long id, Model model) {
        Sets sets = setsRepository.findById(id).orElseThrow();
        setsRepository.delete(sets);
        return "redirect:/sets";
    }
}
