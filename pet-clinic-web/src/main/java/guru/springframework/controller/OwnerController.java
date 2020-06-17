package guru.springframework.controller;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/","/index","/index.html","/find"})
    public String listOwners(Model model){
        int x = 100;
        System.out.println("Owner controller");
        model.addAttribute("owners", ownerService.findAll());
        if(x < 100){
            throw new NumberFormatException("Invalid input");
        }
        return "owners/index";
    }

    @GetMapping("/new")
    //@RequestMapping("/new")
    public ModelAndView newOwnerForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("owners/newOwner");
        mv.addObject("owner", new Owner());
      return mv;
    }

    @PostMapping("createNew")
    public void submitNewOwner(@Valid Model model){

    }

   /* @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatException.class})
    public ModelAndView handleNumberFormatException(Exception ex){
        log.error("Exception occured: "+ ex.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("400error");
        mv.addObject("exception", ex);

        return mv;
    }*/
}
