package ouhk.comps380f.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ouhk.comps380f.dao.TicketUserRepository;
import ouhk.comps380f.exception.UserNotFound;
import ouhk.comps380f.model.TicketUser;
import ouhk.comps380f.model.UserRole;

@Service
public class TicketUserService implements UserDetailsService {
    @Resource
    TicketUserRepository ticketUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        TicketUser ticketUser = ticketUserRepo.findById(username).orElse(null);
        if (ticketUser == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : ticketUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(ticketUser.getUsername(), ticketUser.getPassword(), authorities);
    }
    
    
     public List<TicketUser> getAll(){
        return ticketUserRepo.findAll();
    }
     
         public TicketUser getUser(String username) {
        return ticketUserRepo.findById(username).orElse(null);
    }
     
    @Transactional(rollbackFor = UserNotFound.class)
    public void updateUser(String username,String password,
            String fullname, int phonenumber, String deliveraddress)
            throws IOException, UserNotFound {
        TicketUser updatedTicket = ticketUserRepo.findById(username).orElse(null);
        if (updatedTicket == null) {
            throw new UserNotFound();
        }

        updatedTicket.setUsername(username);
        updatedTicket.setPassword(password);
        updatedTicket.setFullname(fullname);
        updatedTicket.setPhonenumber(phonenumber);
        updatedTicket.setDeliveraddress(deliveraddress);
             
        ticketUserRepo.save(updatedTicket);
    }
}
