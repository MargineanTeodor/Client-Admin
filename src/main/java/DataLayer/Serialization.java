package DataLayer;

import Businesslayer.DeliveryService;

import java.io.*;

public class Serialization {
    public static void serializa(DeliveryService x) throws IOException {
        FileOutputStream file = new FileOutputStream("Bill");
        ObjectOutputStream out= new ObjectOutputStream(file);
        out.writeObject(x);
        out.close();
        file.close();
    }
    public static DeliveryService deserialization() throws IOException, ClassNotFoundException {
        DeliveryService ds=new DeliveryService();
        FileInputStream file = new FileInputStream("Bill");
        ObjectInput in = new ObjectInputStream(file);
        ds=(DeliveryService) in.readObject();
        in.close();
        file.close();
        return ds;
    }
}
