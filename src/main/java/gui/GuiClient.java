package gui;

import Businesslayer.DeliveryService;
import controller.ControllerClientAddOrder;
import controller.ControllerClientListare;
import controller.ControllerClientOrder;
import controller.ControllerClientSearch;

import java.awt.*;
import javax.swing.*;


public class GuiClient extends JPanel {
    private DeliveryService ds= new DeliveryService();
    private JButton list;
    private JButton search;
    private JButton order;
    private JButton add;
    private JTextField addProduct;
    private JLabel product;
    private JTextArea keyword2;
    private JLabel keyword;
    private JLabel rating;
    private JTextArea ratin2;
    private JTextArea calories2;
    private JLabel calories;
    private JLabel proteins;
    private JTextArea proteins2;
    private JLabel fats;
    private JTextArea fats2;
    private JTextArea sodium2;
    private JLabel sodium;
    private JTextArea jcomp19;
    private JLabel price;

    public DeliveryService getDs() {
        return ds;
    }

    public JTextField getAddProduct() {
        return addProduct;
    }

    public JTextArea getKeyword2() {
        return keyword2;
    }

    public JTextArea getRatin2() {
        return ratin2;
    }

    public JTextArea getCalories2() {
        return calories2;
    }

    public JTextArea getProteins2() {
        return proteins2;
    }

    public JTextArea getFats2() {
        return fats2;
    }

    public JTextArea getSodium2() {
        return sodium2;
    }

    public JTextArea getJcomp19() {
        return jcomp19;
    }

    public GuiClient() {
        list = new JButton ("list");
        search = new JButton ("search");
        order = new JButton ("order");
        add = new JButton ("add");
        addProduct = new JTextField (0);
        product = new JLabel ("Product:");
        keyword2 = new JTextArea (1, 1);
        keyword = new JLabel ("keyword");
        ControllerClientListare x= new ControllerClientListare(this);
        list.addActionListener(x);
        rating = new JLabel ("rating");
        ratin2 = new JTextArea (1, 1);
        calories2 = new JTextArea (1, 1);
        calories = new JLabel ("calories");
        ControllerClientSearch x2= new ControllerClientSearch(this);
        search.addActionListener(x2);
        proteins = new JLabel ("proteins");
        proteins2 = new JTextArea (1, 1);
        fats = new JLabel ("fats");
        fats2 = new JTextArea (1, 1);
        sodium2 = new JTextArea (1, 1);
        sodium = new JLabel ("sodium");
        jcomp19 = new JTextArea (5, 5);
        ControllerClientAddOrder x3= new ControllerClientAddOrder(this);
        addProduct.addActionListener(x3);
        price = new JLabel ("price");
        setPreferredSize (new Dimension (625, 500));
        setLayout (null);
        add (list);
        add (search);
        add (order);
        add (add);
        add (addProduct);
        add (product);
        add (keyword2);
        add (keyword);
        add (rating);
        add (ratin2);
        add (calories2);
        add (calories);
        add (proteins);
        add (proteins2);
        add (fats);
        add (fats2);
        add (sodium2);
        add (sodium);
        add (jcomp19);
        add (price);
        list.setBounds (25, 30, 145, 45);
        search.setBounds (25, 80, 145, 45);
        order.setBounds (45, 305, 145, 50);
        add.setBounds (50, 385, 145, 50);
        addProduct.setBounds (315, 390, 160, 50);
        product.setBounds (225, 395, 100, 25);
        keyword2.setBounds (320, 30, 115, 30);
        keyword.setBounds (250, 35, 100, 25);
        rating.setBounds (245, 75, 100, 25);
        ratin2.setBounds (320, 75, 115, 30);
        calories2.setBounds (320, 115, 115, 30);
        calories.setBounds (245, 120, 70, 20);
        proteins.setBounds (240, 160, 70, 25);
        ControllerClientOrder x4= new ControllerClientOrder(this);
        order.addActionListener(x4);
        proteins2.setBounds (320, 160, 115, 30);
        fats.setBounds (245, 205, 50, 20);
        fats2.setBounds (320, 200, 115, 30);
        sodium2.setBounds (320, 235, 115, 35);
        sodium.setBounds (235, 240, 100, 25);
        jcomp19.setBounds (320, 275, 115, 35);
        price.setBounds (240, 275, 100, 25);
    }

    public void main () {
        JFrame frame = new JFrame ("ClientMenu");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiClient());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible (true);
    }
}
