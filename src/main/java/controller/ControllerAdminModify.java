package controller;

import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdminModify implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminModify(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().modifyMenuItem(gui.getProdus().getText());
    }
}
