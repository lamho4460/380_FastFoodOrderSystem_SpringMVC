package ouhk.comps380f.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "item")
public class testForItem implements Serializable {

    @Id
    @Column(name = "itemid")
    private String id;
  
     private String itemname;
    private String description;
    private float price;
    private String quantity;
    
    public testForItem(){}
    
    
    public testForItem(String id,String itemname,String description,float price,String quantity){
          
          this.id = id;
          this.itemname = itemname;
    
          this.description = description;
          this.price = price;
          this.quantity = quantity;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    
}
