package Businesslayer;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int orderID;
    private Date date;
    private int lista;

    public Order(int orderID, Date date, int lista) {
        this.orderID = orderID;
        this.date = date;
        this.lista = lista;
    }

    public Order() {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Order order = (Order) o;
        if(date==null)
            if(order.date != null)
                 return false;
        else
            if(!date.equals(order.date))
                return false;
        if(orderID!= order.orderID)
            return false;
        if(lista!= order.lista)
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result=1;
        result=8*result+date.hashCode();
        result=8*result+orderID;
        result=8*result+lista;
        return result;
    }
}
