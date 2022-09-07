
package ouhk.comps380f.controller;
import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ouhk.comps380f.model.Ticket;
import ouhk.comps380f.model.testForItem;
import ouhk.comps380f.service.TicketService;

@Controller
public class CartController {
     @Autowired
    private TicketService ticketService;
     
     @GetMapping("/cart")
     public String cart()throws ServletException, IOException{        
         return "cart";
     }
     
     @GetMapping("/addcart/{id}")
     public String addcart(@PathVariable("id") long id, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
         HttpSession session = request.getSession();
           Ticket ticket = ticketService.getTicket(id);
                if (session.getAttribute("cart") == null)
             session.setAttribute("cart", new Hashtable<>());
            
            @SuppressWarnings("unchecked")
            Map<String, Integer> cart
                = (Map<String, Integer>) session.getAttribute("cart");
               if (!cart.containsKey(ticket.getSubject()))
             cart.put(ticket.getSubject(), 0);
             cart.put(ticket.getSubject(), cart.get(ticket.getSubject()) + 1);
        
        return "cart";
     }
     
     @GetMapping("/cart/emptycart")
     public String empty(HttpServletRequest request, HttpServletResponse response) {
         request.getSession().removeAttribute("cart");
         return "redirect:/cart";
     }
}
