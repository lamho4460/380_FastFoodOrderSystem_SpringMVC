package ouhk.comps380f.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class TicketUser implements Serializable {
    @Id
    private String username;
   
    private String password;
    private String fullname;
    private int phonenumber;
    private String deliveraddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
          cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> roles = new ArrayList<>();

    public TicketUser() {}

    public TicketUser(String username, String password,String fullname,int phonenumber,String deliveraddress, String[] roles) {
        this.username = username;
        this.password = "{noop}" + password;
        this.fullname= fullname;
        this.phonenumber= phonenumber;
        this.deliveraddress= deliveraddress;
        for (String role : roles) {
            this.roles.add(new UserRole(this, role));
        }
    }

    // getters and setters of all properties
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

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
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

