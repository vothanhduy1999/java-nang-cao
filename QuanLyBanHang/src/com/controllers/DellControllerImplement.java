package com.controllers;

import com.models.Product;
import com.models.ModelProduct;
import com.views.DeleteView;

import javax.swing.*;
import java.awt.*;

public class DellControllerImplement implements DeleteProductController {
    ModelProduct model;
    Component parent;
    DeleteView view;
    public DellControllerImplement(Component parent, ModelProduct model, DeleteView view) {
        this.parent = parent;
        this.model = model;
        this.view = view;
    }
    @Override
    public void deleteStaff(int id) {

        Product product = model.getProductByID(id);
        view.setFullName(product.getFullName());
        view.setFullName(product.getFullName());
        int option = JOptionPane.showConfirmDialog(parent, view.getRootPanel(),
                "Bạn Có Muốn Xóa Tên Hàng",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            model.deleteProduct(id);
        }
    }
}
