package Businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeSet;

public interface IDeliveryServiceProcessing {
    public MenuItem transform2(String s);
    public void deleteOp (String s);
    public ArrayList<MenuItem> transform() throws FileNotFoundException;
    public TreeSet<String> getCSV() throws FileNotFoundException;
    public void addMenuItem(String s);
    public void modifyMenuItem(String s);
    public Order CreateNewOrder(int id, Date date, int lista, ArrayList<MenuItem> list) throws IOException;
    public void seriaalziation() throws IOException;
    public String str(BaseProduct x);
    public String str2(CompositeProduct x);
    public void afisare(ArrayList<MenuItem> lista);
    public HashMap<Order,ArrayList<MenuItem>> raport2(int ct);
    public void createCompositeProduct(ArrayList<MenuItem> e2, String title);
    public void raport1(int x, int y);
    public void addListComposite(String s, ArrayList<MenuItem> e2);
    public ArrayList<MenuItem> searchCriterii(String KeyWord,int proteins,int calories,int fats,int sodium,float rating,double price);
}
