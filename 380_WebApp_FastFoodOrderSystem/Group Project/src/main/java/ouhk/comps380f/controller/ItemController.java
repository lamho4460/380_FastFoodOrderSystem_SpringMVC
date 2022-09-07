package ouhk.comps380f.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ouhk.comps380f.model.testForItem;
import ouhk.comps380f.service.itemService;

@Controller


public class ItemController {
     @Autowired
    itemService iService;
    
        @GetMapping("/view/{id}")
    public String view(@PathVariable("id") String id,
            ModelMap model) {
        
        testForItem item = iService.findById(id);
        
        model.addAttribute("itemid", item);
        return "view";
    }
}
