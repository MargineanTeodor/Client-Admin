package controller;

import Businesslayer.MenuItem;
import gui.GuiClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class ControllerClientAddOrder implements ActionListener {
    private GuiClient gui;
    private int ct=0;
    public ControllerClientAddOrder(GuiClient gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<MenuItem> x2;
        ArrayList<MenuItem> x1= new ArrayList<>();
        try {
            x2=gui.getDs().transform();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        gui.getDs().addListComposite(gui.getJcomp19().getText(),x1);
    }
}
