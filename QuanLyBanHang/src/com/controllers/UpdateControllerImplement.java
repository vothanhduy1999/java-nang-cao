package com.controllers;

import com.models.Product;
import com.models.ModelProduct;
import com.views.UpdateProductView;

import javax.swing.*;
import java.awt.*;

public class UpdateControllerImplement implements UpdateController {
    UpdateProductView view;
    ModelProduct model;
    Component parent;

    public UpdateControllerImplement(Component parent, ModelProduct model, UpdateProductView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }

    @Override
    public void updateStaff(int id) {
        Product product = model.getProductByID(id);
        view.setFullName(product.getFullName());
        view.setAmount(product.getAmount());
        view.setPrices(product.getPrices());
        int option = JOptionPane.showConfirmDialog(parent,
                view.getRootPanel(),
                "Câp Nhập Thông tin Hàng",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!view.getFullName().trim().equals("")) {
                String fullName = view.getFullName();
                int amount = view.getAmount();
                int prices = view.getPrices();

                product.setFullName(fullName);
                product.setAmount(amount);
                product.setPrices(prices);

                model.updateProduct(product);
            } else {
                JOptionPane.showMessageDialog(parent, "Không Được Để Trống Tên Hàng");
            }

        }
    }
}
