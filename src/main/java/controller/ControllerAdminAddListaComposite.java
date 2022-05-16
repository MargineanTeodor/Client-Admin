package controller;

import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerAdminAddListaComposite implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminAddListaComposite(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().addListComposite(gui.getProdus().getText(),gui.getDs().getListComposite());
        gui.getDs().afisare(gui.getDs().getListComposite());
    }
}
