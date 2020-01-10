package com.views;

import javax.crypto.spec.IvParameterSpec;
import javax.swing.*;

public class UpdateProductView implements IView {
    private JPanel rootPanel;
    private JTextField txfFullName;
    private JSpinner txfprices;
    private JSpinner txfAmount;

    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setFullName(String fullName) {
        txfFullName.setText(fullName);
    }

    public String getFullName() {
        return txfFullName.getText();
    }

    public int getAmount(){
        return Integer.parseInt(String.valueOf(txfAmount.getValue()));
    }
    public int getPrices(){
        return Integer.parseInt(String.valueOf(txfprices.getValue()));
    }

    public void setAmount(int amount){
        txfAmount.setValue(amount);
    }
    public void setPrices(int prices){
        txfprices.setValue(prices);
    }
}
