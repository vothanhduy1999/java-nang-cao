package com.models;

import java.util.List;

public interface ProductDataObject {

    void insertStaff(Product product);

    List<Product> getAllStaff();
    List<Product> getAllStaffByName(String name);

    Product getStaffByID(int ID);

    void updateStaff(Product product);

    void deleteStaff(int index);
}
