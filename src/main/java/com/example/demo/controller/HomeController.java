package com.example.demo.controller;

import com.example.demo.dto.StreetDto;
import com.example.demo.entity.District;
import com.example.demo.entity.Street;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin/street")
public class HomeController {
    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    StreetRepository streetRepository;

    @GetMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("districts", districtRepository.findAll());
        model.addAttribute("street", new StreetDto());
        return "create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createStreet(Model model,
                             @Valid @ModelAttribute("street") StreetDto streetDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("districts", districtRepository.findAll());
            model.addAttribute("street", streetDto);
            return "create";
        }

        Street street = streetRepository.findByName(streetDto.getName()).orElse(null);
        if (street != null) {
            bindingResult.addError(new ObjectError("name", "Street name has been taken"));
            model.addAttribute("districts", districtRepository.findAll());
            model.addAttribute("street", streetDto);
            return "create";
        }

        Street nStreet = new Street(streetDto);
        District district = districtRepository.findById(streetDto.getDistrict());
        district.setStreet(nStreet);
        nStreet.setDistrict(district);
        
        streetRepository.save(nStreet);

        return "index";
    }
}
