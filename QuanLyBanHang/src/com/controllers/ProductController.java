package com.controllers;

public interface ProductController extends Controller{

    void addStaff();

    void deleteStaff(int id);

    void updateStaff(int id);

    void search(String name);
}
