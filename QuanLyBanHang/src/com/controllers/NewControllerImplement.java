package com.controllers;

import com.models.Product;
import com.models.ModelProduct;
import com.views.NewProductView;

import javax.swing.*;
import java.awt.*;

public class NewControllerImplement implements NewController {

    NewProductView view;
    ModelProduct model;
    Component parent;

    public NewControllerImplement(Component parent, ModelProduct model, NewProductView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void newStaff() {
        Object[] options = {"Thêm Sản Phẩm ","Hủy"};
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Thêm Sản Phẩm Mới ",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!view.getFullName().trim().equals("")) {

                String fullName = view.getFullName();
                int amount = view.getAmount();
                int prices = view.getPrices();

                Product product = new Product(0, fullName, amount, prices);

                model.addProduct(product);
            }else{
                JOptionPane.showMessageDialog(parent, "Không Được Để Trống");
            }

        }
    }
}
