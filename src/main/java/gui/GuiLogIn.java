package gui;

import controller.ControllerLogIn;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class GuiLogIn extends JPanel {
    private JTextArea user;
    private JLabel user1;
    private JLabel pass1;
    private JTextArea pass;
    private JButton LogIn;
    private JButton Register;
    private ArrayList<Angajat> lista;
    public GuiLogIn(ArrayList<Angajat> p) {
        user = new JTextArea (1, 1);
        user1 = new JLabel ("user");
        pass1 = new JLabel ("pass");
        pass = new JTextArea (0, 1);
        LogIn = new JButton ("LogIn");
        Register = new JButton ("Register");
        lista=p;
        setPreferredSize (new Dimension (350, 270));
        setLayout (null);
        add (user);
        add (user1);
        add (pass1);
        add (pass);
        add (LogIn);
        add (Register);
        ControllerLogIn x= new ControllerLogIn(this);
        LogIn.addActionListener(x);
        user.setBounds (95, 70, 175, 30);
        user1.setBounds (40, 70, 100, 25);
        pass1.setBounds (35, 115, 100, 25);
        pass.setBounds (95, 115, 175, 30);
        LogIn.setBounds (130, 175, 100, 25);
        Register.setBounds (130, 210, 100, 25);
    }

    public String getUser() {
        return user.getText();
    }

    public String getPass() {
        return pass.getText();
    }

    public ArrayList<Angajat> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Angajat> lista) {
        this.lista = lista;
    }

    public static void main(String []args)
    {
        Angajat un=new Angajat("admin","admin",1);
        Angajat doi= new Angajat("client","client",0);
        Angajat trei =new Angajat("worker","worker",2);
        ArrayList<Angajat> list = new ArrayList<>();
        list.add(un);
        list.add(doi);
        list.add(trei);
        JFrame frame = new JFrame ("Login");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiLogIn(list));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
    }
}
