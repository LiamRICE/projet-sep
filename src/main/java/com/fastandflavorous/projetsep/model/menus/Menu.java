package com.fastandflavorous.projetsep.model.menus;

import java.util.*;

/**
 * 
 */
public class Menu {

    /**
     * Default constructor
     */
    public Menu(String name, String image, String description, float price){
        this.name = name;
        this.setImage(image);
        this.setDescription(description);
        this.setPrice(price);
        this.products = new ArrayList<>();
    }

    private String name;

    private String image;

    private String description;

    private float price;

    private List<Product> products;



    /**
     * @return
     */
    public List<Allergen> getAllergens() {
        ArrayList<Allergen> ret = new ArrayList<>();
        for(Product p : products){
            ret.add((Allergen) p.getAllergens());
        }
        return ret;
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public void setProducts(List<Product> products){
        this.products.clear();
        this.products.addAll(products);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    /**
     * @param markup
     * @return
     */
    private float getDefaultPrice(float markup) {
        // TODO implement here
        return 0.0f;
    }

    public String toString(){
        String ret = this.getName() +" | ";
        for(Product product : products){
            ret += product.toString() + ", ";
        }
        ret += " | "+ this.getPrice();
        return ret;
    }

    /**
     *
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     */
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }
}