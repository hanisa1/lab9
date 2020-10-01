
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanisamohamed
 */
public class CashRegister implements ProductObserver {
    private DoubleProperty cash = new SimpleDoubleProperty();

    public CashRegister() {
        cash.set(0.00);
    }

    public final double getCash(){
        return cash.get();
    }
    
    public final void setCash(double cash){
        this.cash.set(cash);
    }
    
    public DoubleProperty cashProperty(){
        return cash;
    }
    
    public void add(double money) {
        cash.set(getCash() + money);
    }

    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
