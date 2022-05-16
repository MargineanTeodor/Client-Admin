package Businesslayer;

import java.awt.*;
import java.util.ArrayList;

public class CompositeProduct extends MenuItem{
    private ArrayList<MenuItem> ingrediente;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private double price;

    public CompositeProduct(ArrayList<MenuItem> ingrediente, String title, float rating, int calories, int proteins, int fats, int sodium, double price) {
        this.ingrediente = ingrediente;
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }
    public void addIngredient(MenuItem ingredient)
    {
        this.ingrediente.add(ingredient);
    }
    @Override
    public double computePrice() {
        return price;
    }

    public ArrayList<MenuItem> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(ArrayList<MenuItem> ingrediente) {
        this.ingrediente = ingrediente;
    }
    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
