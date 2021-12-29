package com.fastandflavorous.projetsep.model.menus;

import java.util.List;

public class FullMenuGroup {

    public FullMenuGroup(List<Menu> m, List<Product> p, List<Allergen> a){
        this.menus = m;
        this.products = p;
        this.allergens = a;
    }

    private List<Menu> menus;
    private List<Product> products;
    private List<Allergen> allergens;

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Allergen> getAllergens() {
        return allergens;
    }
}
