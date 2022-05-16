package controller;

import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdminCreateComposite implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminCreateComposite(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().createCompositeProduct(gui.getDs().getListComposite(), gui.getProdus().getText());
        gui.getDs().afisare(gui.getDs().getList());
    }
}
