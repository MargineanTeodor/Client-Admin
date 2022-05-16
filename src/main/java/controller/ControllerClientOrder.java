package controller;

import Businesslayer.MenuItem;
import gui.GuiClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ControllerClientOrder implements ActionListener {
    private GuiClient gui;
    private int ct=0;
    public ControllerClientOrder(GuiClient gui) {
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
        try {
            gui.getDs().CreateNewOrder(ct,new Date(),1,gui.getDs().getListComposite());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
