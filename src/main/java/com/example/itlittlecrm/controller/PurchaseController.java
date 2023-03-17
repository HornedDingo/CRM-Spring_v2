package com.example.itlittlecrm.controller;

import com.example.itlittlecrm.models.Building;
import com.example.itlittlecrm.models.Products;
import com.example.itlittlecrm.models.Purchase;
import com.example.itlittlecrm.repo.BuildingRepository;
import com.example.itlittlecrm.repo.ProductsRepository;
import com.example.itlittlecrm.repo.PurchaseRepository;
import com.example.itlittlecrm.repo.SalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PurchaseController {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    SalerRepository salerRepository;

    @GetMapping("/purchase")
    public String purchaseMain(Model model) {
        Iterable<Purchase> purchases = purchaseRepository.findAll();
        Iterable<Products> products = productsRepository.findAll();
        Iterable< Building> buildings = buildingRepository.findAll();
        model.addAttribute("purchases", purchases);
        model.addAttribute("buildings", buildingRepository.findAll());
        model.addAttribute("products", productsRepository.findAll());
        return "Purchase/purchase-main";
    }

    @GetMapping("/purchase/add")
    public String purchaseAdd(Purchase purchase, Model model) {
        return getAdd(model, purchase);
    }

    private String getAdd(Model model, Purchase purchase) {

        model.addAttribute("purchase", purchase);
        model.addAttribute("buildings", buildingRepository.findAll());
        model.addAttribute("salers", salerRepository.findAll());
        model.addAttribute("products", productsRepository.findAll());
        return "Purchase/purchase-add";
    }

    @PostMapping("/purchase/add")
    public String purchasePostAdd(@ModelAttribute("purchase") @Valid Purchase purchase, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return getAdd(model, purchase);
        }
        purchaseRepository.save(purchase);
        return "redirect:/purchase";
    }

    @GetMapping("/purchase/{id}")
    public String purchaseDetail(@PathVariable("id") Long id, Model model) {
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        if (optionalPurchase.isPresent()) {
            Purchase purchase = purchaseRepository.findById(id).orElseThrow();
            model.addAttribute("purchase", purchase);
            return "Purchase/purchase-detail";
        } else {
            return "redirect:/purchase";
        }
    }
    @GetMapping("/purchase/{purchase}/edit")
    public String purchaseEdit(Model model, Purchase purchase) {
        return "Purchase/purchase-edit";
    }

    @PostMapping("/purchase/{id}/edit")
    public String purchasePostUpdate(@ModelAttribute("purchase") Purchase purchase, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Purchase/purchase-edit";
        }
        purchaseRepository.save(purchase);
        return "redirect:/purchase";
    }

    @PostMapping("/purchase/{id}/delete")
    public String purchasePostDelete(@ModelAttribute("Purchase") Purchase purchase) {
        purchaseRepository.delete(purchase);
        return "redirect:/purchase";
    }
}
