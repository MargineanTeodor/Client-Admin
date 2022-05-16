package controller;

import Businesslayer.MenuItem;
import Businesslayer.Order;
import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ControllerAdminRaport implements ActionListener {
    private GuiAdmin gui;
    public ControllerAdminRaport(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().addListComposite("produs",gui.getDs().getListComposite());
        try {
            gui.getDs().CreateNewOrder(1,new Date(),1,gui.getDs().getListComposite());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gui.getDs().raport1(13,14);
    }
}
