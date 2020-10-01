
import java.util.LinkedList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanisamohamed
 */
public class Product {
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private final String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock.set(stock);
        this.price.set(price);
    }
    
    public final int getStock(){
        return stock.get();
    }
    
    public final void setStock(int stock){
        this.stock.set(stock);
    }
    
    public IntegerProperty stockProperty(){
        return stock;
    }
    
    public final double getPrice(){
        return price.get();
    }
    
    public final void setPrice(int price){
        this.price.set(price);
    }
    
    public DoubleProperty priceProperty(){
        return price;
    }
    
    public final String getName(){
        return name;
    }
    

    public void sell(int n) {
        stock.set(getStock() - n);
        double money = n * getPrice();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n) {
        stock.set(getStock() + n);
    }

    public boolean has(int n) {
        return getStock() >= n;
    }

    public void addProductObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public String toString() {
        return stock + " " + name + " at $" + price;
    }
}
