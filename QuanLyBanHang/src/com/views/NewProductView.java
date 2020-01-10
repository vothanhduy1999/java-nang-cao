package com.views;

import javax.swing.*;

public class NewProductView implements IView{
    private JPanel rootPanel;
    private JTextField txfFullName;
    private JSpinner txfAmount;
    private JSpinner txfprices;

    public JPanel getRootPanel() {
        return rootPanel;
    }
    public String getFullName(){
        return txfFullName.getText();
    }
    public int getAmount(){
        return Integer.parseInt(String.valueOf(txfAmount.getValue()));
    }
    public int getPrices(){
        return Integer.parseInt(String.valueOf(txfprices.getValue()));
    }
}
