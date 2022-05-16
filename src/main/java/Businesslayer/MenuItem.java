package Businesslayer;

import java.util.Collection;

public abstract class MenuItem {
    public abstract double computePrice();
    String title;
    public String getTitle() {
        return title;
    }
}
