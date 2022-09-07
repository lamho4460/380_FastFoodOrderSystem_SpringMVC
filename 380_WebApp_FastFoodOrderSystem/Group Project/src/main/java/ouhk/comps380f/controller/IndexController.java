package ouhk.comps380f.controller;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ouhk.comps380f.service.TicketService;
import ouhk.comps380f.service.itemService;

@Controller
public class IndexController {

    /*@GetMapping
    public String index() {
        return "redirect:/ticket/list";
    }*/
    @Autowired
    itemService iService;
    
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public String Index(ModelMap model){
        model.addAttribute("ticketDatabase", ticketService.getTickets());
        return "index";
    }
        @GetMapping("/login")
    public String login(HttpServletRequest request) {
        if ( request.isUserInRole("ROLE_ADMIN")
                || request.isUserInRole("ROLE_USER") ) {
            return "redirect:/";
        }
        return "login";
    }
  
 
    /*
    @GetMapping("")
    public String getIndex(ModelMap model,Principal principal){
        List itemAll = iService.getAll();
        model.addAttribute("itemAll", itemAll);
       
        return ("index/"+ principal.getName());
    }
    */
}
