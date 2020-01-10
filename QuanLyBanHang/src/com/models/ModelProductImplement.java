package com.models;

import java.util.List;
import java.util.Vector;

public class ModelProductImplement implements ModelProduct {

    List<TableObserver> observers = new Vector<>();

    @Override
    public List<Product> getAllProduct() {
        ProductDataObject dao = new ProductDataObjectImplement();
        return dao.getAllStaff();
    }

    @Override
    public List<Product> getAllProductByName(String name) {
        ProductDataObject dao = new ProductDataObjectImplement();
        return dao.getAllStaffByName(name);
    }

    @Override
    public Product getProductByID(int id) {
        ProductDataObject dao = new ProductDataObjectImplement();
        return dao.getStaffByID(id);
    }

    @Override
    public void addProduct(Product product) {

        ProductDataObject dao = new ProductDataObjectImplement();
        dao.insertStaff(product);
        notifyObservers();
    }

    @Override
    public void deleteProduct(int index) {

        ProductDataObject dao = new ProductDataObjectImplement();
        dao.deleteStaff(index);
        notifyObservers();
    }

    @Override
    public void updateProduct(Product product) {
        ProductDataObject dao = new ProductDataObjectImplement();
        dao.updateStaff(product);
        notifyObservers();
    }

    @Override
    public void registerObserver(TableObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(TableObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        List<Product> students = getAllProduct();
        for (TableObserver observer : observers) {
            observer.update(students);
        }
    }
}
