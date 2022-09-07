
package ouhk.comps380f.service;

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
import ouhk.comps380f.dao.TicketUserRepository;
import ouhk.comps380f.dao.itemRepository;
import ouhk.comps380f.model.TicketUser;
import ouhk.comps380f.model.UserRole;
import ouhk.comps380f.model.testForItem;

/**
 *
 * @author lamwo
 */
@Service
public class itemService  {

    @Resource
    itemRepository itemRepo;

    public testForItem loadItemByID(String id)
            throws UsernameNotFoundException {
        testForItem item = itemRepo.findById(id).orElse(null);
        if (item == null) {
            throw new UsernameNotFoundException("item '" + id + "' not found.");
        }
        return item;

}
    
    public List<testForItem> getAll(){
        return itemRepo.findAll();
    }
    
        public testForItem findById(String id){
        return itemRepo.findById(id).orElse(null);
    }
}
