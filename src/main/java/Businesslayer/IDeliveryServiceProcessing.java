package Businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public interface IDeliveryServiceProcessing {
    public MenuItem transform2(String s);
    /**
     *
     * @param s = sirul de cautat trebuie sa se gaseasca in lista
     * @throws IOException
     */
    public void deleteOp (String s);
    public ArrayList<MenuItem> transform() throws FileNotFoundException;
    public TreeSet<String> getCSV() throws FileNotFoundException;
    /**
     *
     * @param s = sirul de adaugata in lista
     *          - se verifica lungimea listei initial si dupa daca a fost incrementata cu 1
     * @throws IOException
     */
    public void addMenuItem(String s);
    /**
     *
     * @param s = sirul de cautat trebuie sa se gaseasca in lista
     * @throws IOException
     */
    public void modifyMenuItem(String s);
    /**
     *
     * @param lista = lista care sa nu fie goala
     * @throws IOException
     */
    public Order CreateNewOrder(int id, Date date, int lista, ArrayList<MenuItem> list) throws IOException;
    public void seriaalziation() throws IOException;
    public String str(BaseProduct x);
    public String str2(CompositeProduct x);
    /**
     *
     * @param lista = lista care sa nu fie goala
     * @throws IOException
     */
    public void afisare(ArrayList<MenuItem> lista);
    public void raport2(int ct);
    /**
     *
     * @param e2 = lista care sa nu fie goala
     * @throws IOException
     */
    public void createCompositeProduct(ArrayList<MenuItem> e2, String title);
    public void raport1(int x, int y);
    public void addListComposite(String s, ArrayList<MenuItem> e2);
    public ArrayList<MenuItem> searchCriterii(String KeyWord,int proteins,int calories,int fats,int sodium,float rating,double price);
}
