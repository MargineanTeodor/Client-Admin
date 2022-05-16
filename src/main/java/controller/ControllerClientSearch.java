package controller;

import Businesslayer.MenuItem;
import gui.GuiClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class ControllerClientSearch implements ActionListener {
    private GuiClient gui;
    public ControllerClientSearch(GuiClient gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<MenuItem> x2;

        try {
            x2=gui.getDs().transform();
        } catch (FileNotFoundException ex) {
            System.out.println("Sheeesh");
            ex.printStackTrace();
        }
        x2=gui.getDs().searchCriterii(gui.getKeyword2().getText(),parseInt(gui.getProteins2().getText()),
                    parseInt(gui.getCalories2().getText()),parseInt(gui.getFats2().getText()),parseInt((gui.getSodium2().getText())),
                    3.5f,20);
           // gui.getDs().afisare(x2);

        }
    }
