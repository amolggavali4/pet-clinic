package guru.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    @RequestMapping({"","/","/index","/index.html"})
    public String listOwners(){
        System.out.println("Owner controller");
        return "owners/index";
    }
}
