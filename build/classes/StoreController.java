/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author hanisamohamed
 */
public class StoreController {
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;
    
    Store store = new Store();
    
    Product product = store.getProduct();
    CashRegister cashRegister = store.getCashRegister();
    
    @FXML private void initialize(){
        stockTxt.textProperty().bind(product.stockProperty().asString().concat(" items"));
        priceTxt.textProperty().bind(product.priceProperty().asString("$%.2f"));
        cashTxt.textProperty().bind(cashRegister.cashProperty().asString("$%.2f"));
        amountTf.setText("0");
    }
    
    public final Store getStore(){
        return store;
    }
}
