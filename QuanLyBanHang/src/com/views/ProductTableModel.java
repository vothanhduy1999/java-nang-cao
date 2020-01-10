package com.views;

import com.models.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ProductTableModel extends AbstractTableModel {
    private List<Product> products = new Vector<>();

    private static final String[] COLUMN_NAMES = {"STT", " Tên Hàng", "Số Lượng", "Giá"};
    private static final int ID = 0;
    private static final int FULL_NAME = 1;
    private static final int AMOUNT = 2;
    private static final int PRICES =3;
    @Override
    public int getRowCount() {
        return products.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Product product = products.get(rowIndex);
        if (columnIndex == ID) {
            return product.getID();
        } else if (columnIndex == FULL_NAME) {
            return product.getFullName();
        } else if (columnIndex == AMOUNT){
            return product.getAmount();
        }else if(columnIndex == PRICES){
            return product.getPrices();
        }
        return null;
    }
    public void update(List<Product> products){

        this.products.clear();
        this.products.addAll(products);
        fireTableDataChanged();
    }
}
