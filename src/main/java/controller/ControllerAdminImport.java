package controller;

import Businesslayer.MenuItem;
import gui.Angajat;
import gui.GuiAdmin;
import gui.GuiClient;
import gui.GuiLogIn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerAdminImport implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminImport(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<MenuItem> x= new ArrayList<>();
        try {
            x=gui.getDs().transform();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        gui.getDs().afisare(x);
    }
}
