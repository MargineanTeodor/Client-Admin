package controller;

import gui.Angajat;
import gui.GuiLogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerRegister  implements ActionListener {
    private GuiLogIn gui;

    public ControllerRegister(GuiLogIn gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Angajat e2= new Angajat(this.gui.getUser(),this.gui.getPass(),0);
        this.gui.getLista().add(e2);
    }
}
