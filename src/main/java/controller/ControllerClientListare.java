package controller;

import Businesslayer.MenuItem;
import gui.GuiClient;
import gui.GuiLogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerClientListare implements ActionListener {
    private GuiClient gui;
    public ControllerClientListare(GuiClient gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<MenuItem> x2;
        try {
            x2=gui.getDs().transform();
            gui.getDs().afisare(x2);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
