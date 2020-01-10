package com.views;

import com.controllers.ProductController;
import com.models.Product;
import com.models.ModelProduct;
import com.models.TableObserver;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ProductView implements IView, TableObserver {
    private JPanel rootPanel;
    private JTable tableStaff;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextField txfSearch;
    private JButton searchButton;
    private ProductTableModel nhanVienTableModel;
    ModelProduct model;
    ProductController controller;

    public ProductView(ModelProduct model, ProductController controller) {
        this.model = model;
        this.controller = controller;

        nhanVienTableModel = new ProductTableModel();

        tableStaff.setModel(nhanVienTableModel);
        tableStaff.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.registerObserver(this);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addStaff();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableStaff.getSelectedRow();
                if (row >= 0) {
                    int id = Integer.parseInt(tableStaff.getValueAt(row, 0).toString());
                    controller.deleteStaff(id);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableStaff.getSelectedRow();
                if (row >= 0) {
                    int id = Integer.parseInt(tableStaff.getValueAt(row, 0).toString());
                    controller.updateStaff(id);
                }
            }
        });

        tableStaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = tableStaff.getSelectedRow();
                    if (row >= 0) {
                        int id = Integer.parseInt(tableStaff.getValueAt(row, 0).toString());
                        controller.updateStaff(id);
                    }
                }
            }
        });
        List<Product> products = this.model.getAllProduct();
        nhanVienTableModel.update(products);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txfSearch.getText().isEmpty()) {
                    List<Product> products = model.getAllProduct();
                    nhanVienTableModel.update(products);
                } else {
                    List<Product> products = model.getAllProductByName(txfSearch.getText());
                    nhanVienTableModel.update(products);
                }

            }
        });
    }

    @Override
    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void update(List<Product> productList) {
        nhanVienTableModel.update(productList);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
