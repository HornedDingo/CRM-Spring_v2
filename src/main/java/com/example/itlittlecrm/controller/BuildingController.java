package com.example.itlittlecrm.controller;

import com.example.itlittlecrm.models.Building;
import com.example.itlittlecrm.repo.BuildingRepository;
import com.example.itlittlecrm.repo.ProductsRepository;
import com.example.itlittlecrm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuildingController {
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductsRepository productsRepository;
    @GetMapping("/building")
    public String buildingMain(Model model) {
        Iterable<Building> buildings = buildingRepository.findAll();
        model.addAttribute("buildings", buildings);
        model.addAttribute("users", userRepository.findAll());
        return "Building/building-main";
    }

    @GetMapping("/building/add")
    public String buildingAdd(Building building, Model model) {
        return getAdd(model, building);
    }

    private String getAdd(Model model, Building building) {
        model.addAttribute("building", building);
        return "Building/building-add";
    }

    @PostMapping("/building/add")
    public String buildingPostAdd(Building building, Model model) {
        buildingRepository.save(building);
        return "redirect:/building";
    }

    @GetMapping("/building/{building}")
    public String buildingDetail(Building building, Model model) {
        return "Building/building-detail";
    }

    @GetMapping("/building/{building}/edit")
    public String buildingEdit(Building building, Model model) {
        return "Building/building-edit";
    }

    @PostMapping("/building/{id}/edit")
    public String buildingPostUpdate(@ModelAttribute("Building") Building building, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Building/building-edit";
        }
        buildingRepository.save(building);
        return "redirect:/building";
    }

    @PostMapping("/building/{id}/delete")
    public String buildingPostDelete(@ModelAttribute("Building") Building building) {
        buildingRepository.delete(building);
        return "redirect:/building";
    }
}
