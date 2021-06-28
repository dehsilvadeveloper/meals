package com.teste.meals.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de model
 *
 * @author Andre Silva
 * @version 1.0
 * @since 2021-06-27
 */

public class PratoList {
    
    private List<Prato> meals;

    public PratoList() {
        meals = new ArrayList<>();
    }

    public List<Prato> getMeals() {
        return this.meals;
    }

    public void setMeals(List<Prato> meals) {
        this.meals = meals;
    }

}
