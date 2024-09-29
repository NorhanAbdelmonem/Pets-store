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
public class productData {
      private Integer productId;
    private String name;
    private String status;
    private Double price;
    private Date date;
    private String image;
     public productData(Integer productId, String name, String status, Double price
            , String image, Date date){
        this.productId = productId;
        this.name = name;
        this.status = status;
        this.price = price;
        this.date = date;
        this.image = image;
    }
    
    public Integer getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public String getStatus(){
        return status;
    }
    public Double getPrice(){
        return price;
    }
    public Date getDate(){
        return date;
    }
    public String getImage(){
        return image;
    }
    
}

