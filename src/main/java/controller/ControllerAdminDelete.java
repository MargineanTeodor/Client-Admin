package controller;

import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdminDelete implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminDelete(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().deleteOp(gui.getProdus().getText());

    }
}
