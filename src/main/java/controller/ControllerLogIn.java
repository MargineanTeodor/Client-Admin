package controller;

import gui.Angajat;
import gui.GuiAdmin;
import gui.GuiClient;
import gui.GuiLogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerLogIn implements ActionListener {
    private GuiLogIn gui;
    public ControllerLogIn(GuiLogIn gui) {
        this.gui = gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
           ArrayList<Angajat> p= new ArrayList<>();
           int sem=0;
           p=gui.getLista();
           String pass=gui.getPass();
           String id=gui.getUser();
        for (Angajat e2:p) {
            if (e2.getId().equals(id) && e2.getPass().equals(pass)) {
                sem=1;
                if (e2.getAdmin() == 0)
                    new GuiClient().main();
                else if(e2.getAdmin()==1) {
                    try {
                        new GuiAdmin().main();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        if(sem==0)
            try {
                throw new UserDefinedException("Invalid Login");
            } catch (UserDefinedException ex) {
                ex.printStackTrace();
            }
    }
}
