package controller;

import Businesslayer.MenuItem;
import Businesslayer.Order;
import gui.GuiAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ControllerAdminRaport implements ActionListener, Serializable {
    private GuiAdmin gui;
    public ControllerAdminRaport(GuiAdmin gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gui.getDs().addListComposite(gui.getProdus().getText(),gui.getDs().getListComposite());
        try {
            gui.getDs().CreateNewOrder(1,new Date(),1,gui.getDs().getListComposite());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        gui.getDs().raport1(0,24);
        gui.getDs().raport2(1);
    }
}
