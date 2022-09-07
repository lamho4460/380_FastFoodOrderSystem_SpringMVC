package ouhk.comps380f.controller;

import java.io.IOException;
import java.security.Principal;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ouhk.comps380f.dao.TicketUserRepository;
import ouhk.comps380f.exception.TicketNotFound;
import ouhk.comps380f.exception.UserNotFound;
import ouhk.comps380f.model.TicketUser;
import ouhk.comps380f.service.TicketUserService;

@Controller
@RequestMapping("/user")
public class TicketUserController {
 @Autowired
    private TicketUserService ticketuserService;
    @Resource
    TicketUserRepository ticketUserRepo;

    @GetMapping({"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("ticketUsers", ticketUserRepo.findAll());
        return "listUser";
    }

    public static class Form {

        private String username;
        private String password;
        private String fullname;
        private int phonenumber;
        private String deliveraddress;
        private String[] roles;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String[] getRoles() {
            return roles;
        }

        public void setRoles(String[] roles) {
            this.roles = roles;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public int getPhonenumber() {
            return phonenumber;
        }

        public void setPhonenumber(int phonenumber) {
            this.phonenumber = phonenumber;
        }

        public String getDeliveraddress() {
            return deliveraddress;
        }

        public void setDeliveraddress(String deliveraddress) {
            this.deliveraddress = deliveraddress;
        }
        
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("addUser", "ticketUser", new Form());
    }

    @PostMapping("/create")
    public View create(Form form) throws IOException {
        TicketUser user = new TicketUser(form.getUsername(),
                form.getPassword(),form.getFullname(),form.getPhonenumber(),form.getDeliveraddress(), form.getRoles()
        );
        ticketUserRepo.save(user);
        return new RedirectView("/", true);
    }
    @GetMapping("/updateUser/{username}")
    public ModelAndView showEdit(@PathVariable("username") String username,
            Principal principal, HttpServletRequest request) {
        TicketUser user = ticketuserService.getUser(username);
        if (user == null
                || (!request.isUserInRole("ROLE_ADMIN"))) {
            return new ModelAndView(new RedirectView("/", true));
        }

        ModelAndView modelAndView = new ModelAndView("updateUser");
        modelAndView.addObject("user", user);

        Form UserForm = new Form();
        UserForm.setUsername(user.getUsername());
        UserForm.setPassword(user.getPassword());
        UserForm.setFullname(user.getFullname());
        UserForm.setPhonenumber(user.getPhonenumber());
        UserForm.setDeliveraddress(user.getDeliveraddress());
        modelAndView.addObject("UserForm", UserForm);

        return modelAndView;
    }

    @PostMapping("/updateUser/{username}")
    public String edit(@PathVariable("username") String username, Form form,
            Principal principal, HttpServletRequest request)
            throws IOException, TicketNotFound, UserNotFound {
        TicketUser user = ticketuserService.getUser(username);
        if (user == null
                || (!request.isUserInRole("ROLE_ADMIN"))) {
            return "redirect:/user";
        }

        ticketuserService.updateUser(username, form.getPassword(),
                form.getFullname(), form.getPhonenumber(), form.getDeliveraddress());
        return "redirect:/user/" + username;
    }
    
    
    @GetMapping("/delete/{username}")
    public View deleteTicket(@PathVariable("username") String username) {
        ticketUserRepo.delete(ticketUserRepo.findById(username).orElse(null));
        return new RedirectView("/", true);
    }
}
