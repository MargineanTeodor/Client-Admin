package Businesslayer;

import DataLayer.FileWriter;
import DataLayer.Serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class DeliveryService extends Observable  implements IDeliveryServiceProcessing, Serializable {
    private ArrayList<MenuItem> list= new ArrayList<>();
    private ArrayList<MenuItem> listComposite= new ArrayList<>();
    private HashMap<Order,ArrayList<MenuItem>> map= new HashMap<>();

    public ArrayList<MenuItem> getListComposite() {
        return listComposite;
    }

    public ArrayList<MenuItem> getList() {
        return list;
    }

    @Override
    public TreeSet<String> getCSV() throws FileNotFoundException {
        TreeSet<String> x= new TreeSet<>();
        Scanner sc = new Scanner(new File("D:\\PT_2022_30226_Marginean_Teodor_Assignment_4\\products.csv"));
        sc.useDelimiter(",");
        sc.nextLine();
        while (sc.hasNext()) {
           // System.out.println(sc.nextLine());
            x.add(sc.nextLine());
        }
        sc.close();
        return x;
    }
    @Override
    public MenuItem transform2(String s)
    {
        BaseProduct x= new BaseProduct();
        StringTokenizer st = new StringTokenizer(s,",");
        x.setTitle(st.nextToken());
        x.setRating(parseFloat(st.nextToken()));
        x.setCalories(parseInt(st.nextToken()));
        x.setProteins(parseInt(st.nextToken()));
        x.setFats(parseInt(st.nextToken()));
        x.setSodium(parseInt(st.nextToken()));
        x.setPrice(parseInt(st.nextToken()));
        return x;
    }
    @Override
    public ArrayList<MenuItem> transform() throws FileNotFoundException {
        TreeSet<String> strings=this.getCSV();
        ArrayList<MenuItem> x = new ArrayList<>();
        for (String s:strings
             ) {
            MenuItem x2= transform2(s);
            x.add(x2);
        }
        x.stream().sorted();
        this.list=x;
        return x;
    }

    @Override
    public void deleteOp (String s)
    {
        ArrayList< MenuItem> x2 =new ArrayList<>();
        assert list.size()!=0;
        for (int i=0;i<list.size();i++)
        {
            if(list.get(i) instanceof BaseProduct)
            {
                if(( list.get(i)).getTitle().equals(s))
                    list.remove(list.get(i));
                else
                    x2.add(list.get(i));
            }
        }
        this.list=x2;
        this.afisare(x2);
    }
    @Override
    public void addMenuItem(String s)
    {
        int ct=this.list.size();
        BaseProduct e2= new BaseProduct(s,3,50,50,50,10,200);
        this.list.add(e2);
        assert ct+1==this.list.size();
        this.afisare(this.list);
    }
    @Override
    public void modifyMenuItem(String s)
    {
        for (int i=0;i<list.size();i++) {
            if(list.get(i) instanceof BaseProduct)
            {
                if(( list.get(i)).getTitle().equals(s))
                {
                    BaseProduct e2= new BaseProduct(( list.get(i)).getTitle(),3,50,50,50,10,200);
                    list.remove(list.get(i));
                    list.add(e2);
                }
            }
        }
        this.afisare(this.list);
    }
    @Override
    public Order CreateNewOrder(int id,Date date, int lista, ArrayList<MenuItem> list) throws IOException {
        assert id !=0;
        assert lista != 0;
        assert list.size()>0;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Order order= new Order(id, date ,lista);
        map.put(order,list);
        FileWriter x= new FileWriter();
        x.createBill(order.getOrderID(),formatter.format(order.getDate()),order.getLista(),200);
        return order;
    }
    @Override
    public  void seriaalziation() throws IOException {
        Serialization.serializa(this);
    }
    @Override
    public ArrayList<MenuItem> searchCriterii(String KeyWord,int proteins,int calories,int fats,int sodium,float rating,double price){
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) list.stream()
                .filter(m -> m.getTitle().contains(KeyWord))
                .filter(m -> ((BaseProduct) m).getProteins()>proteins)
                .filter(m -> (((BaseProduct) m).getCalories()<calories))
                .filter(m ->((BaseProduct)m).getSodium()<fats)
                .filter(m -> (((BaseProduct) m).getSodium()<sodium))
                .filter(m -> (((BaseProduct) m).getRating()<rating))
                .filter(m -> (m.computePrice()<price))
                .collect(Collectors.toList());
        this.afisare(menu);
        return menu;
    }
    @Override
    public String str(BaseProduct x)
    {
      return x.getTitle()+" "+x.getCalories()+" "+x.getProteins()+" "+x.getFats()+" "+x.getSodium()+" "+x.computePrice();
    }
    @Override
    public void afisare(ArrayList<MenuItem> lista)
    {
        assert lista.size()>0;
        for(MenuItem e: lista)
        {

            if(e instanceof CompositeProduct)
            {
                System.out.println(this.str2((CompositeProduct) e));
            }
            else
                System.out.println(this.str((BaseProduct) e));

        }
    }
    @Override
    public String str2(CompositeProduct x) {
        return x.getTitle()+" "+x.getCalories()+" "+x.getProteins()+" "+x.getFats()+" "+x.getSodium()+" "+x.computePrice();
    }
    @Override
    public void addListComposite(String s, ArrayList<MenuItem> e2)
    {
        for(int i=0;i<this.list.size();i++)
        {
            if(this.list.get(i).getTitle().contains(s))
                e2.add(this.list.get(i));
        }
    }
    @Override
    public void raport1(int ora1, int ora2){
        this.map.entrySet().stream()
                .filter(m -> m.getKey().getDate().getHours() > ora1)
                .filter(m -> m.getKey().getDate().getHours() < ora2)
                .forEach(m -> {
                    this.afisare(m.getValue());
                });
    }
    @Override
    public void raport2(int ct){
        this.map.entrySet().stream()
                .filter(m -> m.getValue().size()>=ct)
                .forEach(m->{
                    this.afisare(m.getValue());
                });
    }
    @Override
    public void createCompositeProduct(ArrayList<MenuItem> e2, String title)
    {
         float rating = 0;
        int calories=0;
        int proteins=0;
        int fats=0;
        int sodium=0;
         double price=0;
         assert e2.size()>0;
        for (Object menuItem : e2) {
            BaseProduct x = ((BaseProduct) menuItem);
            title=title+" "+x.getTitle();
            fats = fats + x.getFats();
            sodium = sodium + x.getSodium();
            price = price + x.computePrice();
            calories = calories + x.getCalories();
            proteins = proteins + x.getProteins();
            rating = 3;
        }
        CompositeProduct x2= new CompositeProduct(e2,title,rating,calories,proteins,fats,sodium,price);
        this.list.add(x2);
        e2.clear();
    }

}
