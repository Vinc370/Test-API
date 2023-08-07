package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.Region;
import com.example.demo.Services.RegionService;

@Controller
@RequestMapping("region")
public class RegionController {
    
    @Autowired
    private RegionService<Region> regionService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("region", regionService.getAll());
        return "region/index";
    }

    @GetMapping(value = {"form", "form/{id}"}) // https://localhost:8088/form
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("region", regionService.Get(id));
            model.addAttribute("regions", regionService.getAll());
        }
        else{
            model.addAttribute("region", new Region());
            model.addAttribute("regions", regionService.getAll());
        }

        return "region/form";
    }

    @PostMapping("save")
    public String submit(Region region){
        Boolean result = regionService.Insert(region);
        if (result){
            return "redirect:/region";
        }
        else{
            return "region/form";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id){
        regionService.Delete(id);
        return "redirect:/region";
    }
}
