/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petstore;

import java.util.Date;

/**
 *
 * @author Norhan
 */
public class customerData {
    
    
      
    private Integer customerId;
    private Integer productId;
    private String name;
    private Integer quantity;
    private Double price;
    private Date date;
    
    public customerData(Integer customerId, Integer productId, String name
            , Integer quantity, Double price, Date date){
        this.customerId = customerId;
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
    
    public Integer getCustomerId(){
        return customerId;
    }
    public Integer getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public Double getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }
    
}
    

