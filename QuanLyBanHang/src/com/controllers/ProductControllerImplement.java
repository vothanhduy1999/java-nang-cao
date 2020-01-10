package com.controllers;

import com.models.ModelProduct;
import com.views.*;

public class ProductControllerImplement implements ProductController {

    ProductView view;
    ModelProduct model;
    public ProductControllerImplement(ModelProduct model) {
        this.model = model;
        view = new ProductView(model, this);
    }
    @Override
    public IView getView(){
        return view;
    }
    @Override
    public void addStaff() {

        NewController newNvController = new NewControllerImplement(view.getRootPanel(), model, new NewProductView());
        newNvController.newStaff();
    }

    @Override
    public void deleteStaff(int id) {
        DeleteProductController delNvController = new DellControllerImplement(view.getRootPanel(),
                model, new DeleteView());
        delNvController.deleteStaff(id);
    }

    @Override
    public void updateStaff(int id) {

        UpdateController updateController = new UpdateControllerImplement(view.getRootPanel(), model,
                new UpdateProductView());

        updateController.updateStaff(id);
    }

    @Override
    public void search(String name) {

    }
}
