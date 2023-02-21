//Pair programmed with Rochelle B. 
package com.dominic.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dominic.dojo.models.Dojo;
import com.dominic.dojo.models.Ninja;
import com.dominic.dojo.services.DojoService;
import com.dominic.dojo.services.NinjaService;

@Controller
public class MainController {

  @Autowired DojoService dojoService;
  @Autowired NinjaService ninjaService;
  
  @RequestMapping(value={"/dojos/new", "/"})
  public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
    return "dojos/new.jsp";
  }

  @PostMapping("/dojos")
  public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
    dojoService.createDojo(dojo);
    return "redirect:/";
  }

  @RequestMapping("/ninjas/ninja")
  public String newDojo(@ModelAttribute("ninja") Ninja ninja, Model model) {
    List<Dojo> dojos = dojoService.allDojos();
    model.addAttribute("dojos", dojos);
    return "ninjas/ninja.jsp";
  } 

  @PostMapping("createninja")
  public String ninjas(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
    if(result.hasErrors()){
      return "ninjas/ninja.jsp";
    }else {
      ninjaService.createNinja(ninja);
      return "redirect:/show" + ninja.getDojo().getId();
    }
  } 

  @RequestMapping("/show/{dojo_id}")
  public String oneDojo(@PathVariable("dojo_id") Long id, Model model){
    Dojo dojo = dojoService.getDojo(id);
    model.addAttribute("dojo", dojo);
    return "dojo/show.jsp";
  }
}
