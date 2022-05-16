package DataLayer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter {

    public void createBill(int order, String date,int listNr, double price) throws IOException {
        File file = new File("Bill"+ order+ ".txt");
        if(!file.exists())
        {
            file.createNewFile();
            PrintWriter p=new PrintWriter(file);
            p.println("Bill");
            p.println("Nr. "+order);
            p.println("loc "+ listNr);
            p.println("Date of creation: "+ date );
            p.close();
        }
    }
}
