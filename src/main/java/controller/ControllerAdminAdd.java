package controller;

import Businesslayer.MenuItem;
import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ControllerAdminAdd implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminAdd(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().addMenuItem(gui.getProdus().getText());

    }
}
