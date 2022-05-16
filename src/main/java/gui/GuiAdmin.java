package gui;

import Businesslayer.DeliveryService;
import controller.*;

import java.awt.*;
import javax.swing.*;


public class GuiAdmin extends JPanel {
    private JButton import2;
    private JButton add;
    private JButton delete;
    private JButton modify;
    private JButton create;
    private JTextArea produs;
    private JButton addCreate;
    private JButton raport;
    private JLabel produs2;
    private DeliveryService ds= new DeliveryService();

    public JTextArea getProdus() {
        return produs;
    }

    public DeliveryService getDs() {
        return ds;
    }

    public GuiAdmin() {
        //construct components
        import2 = new JButton ("import2");
        add = new JButton ("add");
        delete = new JButton ("delete");
        modify = new JButton ("modify");
        create = new JButton ("create");
        raport = new JButton ("raport");
        produs = new JTextArea (1, 1);
        addCreate = new JButton ("addCreate");
        produs2 = new JLabel ("Product:");
        ControllerAdminImport x= new ControllerAdminImport(this);
        import2.addActionListener(x);
        ControllerAdminAdd x2= new ControllerAdminAdd(this);
        add.addActionListener(x2);
        ControllerAdminDelete x3 = new ControllerAdminDelete(this);
        delete.addActionListener(x3);
        ControllerAdminModify x4= new ControllerAdminModify(this);
        modify.addActionListener(x4);
        ControllerAdminAddListaComposite x5 = new ControllerAdminAddListaComposite(this);
        addCreate.addActionListener(x5);
        ControllerAdminCreateComposite x6 =new ControllerAdminCreateComposite(this);
        create.addActionListener(x6);
        ControllerAdminRaport x7 = new ControllerAdminRaport(this);
        raport.addActionListener(x7);
        setPreferredSize (new Dimension (775, 382));
        setLayout (null);
        add (import2);
        add (add);
        add (delete);
        add (modify);
        add (create);
        add (produs);
        add (addCreate);
        add (produs2);
        add(raport);
        import2.setBounds (40, 25, 120, 60);
        add.setBounds (40, 100, 120, 55);
        delete.setBounds (40, 165, 120, 55);
        modify.setBounds (40, 230, 120, 60);
        create.setBounds (595, 180, 120, 60);
        produs.setBounds (525, 95, 150, 45);
        addCreate.setBounds (445, 180, 120, 60);
        produs2.setBounds (390, 100, 100, 25);
        raport.setBounds(40,300,120,55);
    }


    public  void main () {
        JFrame frame = new JFrame ("AdminMenu");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiAdmin());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
    }
}