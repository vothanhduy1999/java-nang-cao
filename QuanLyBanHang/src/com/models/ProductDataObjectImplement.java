package com.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Vector;

public class ProductDataObjectImplement implements ProductDataObject {

    private final String TABLE_NAME = "product";
    private final String ID = "id";
    private final String PRODUCT_NAME = "productName";
    private final String PRICES = "prices";
    private final String AMOUNT = "amount";

    public ProductDataObjectImplement() {
        Database db = new Database();
        String SQL_CREATE_TABLE_STAFF = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(\n"
                + ID + " integer PRIMARY KEY AUTOINCREMENT,\n"
                + PRODUCT_NAME + " text NOT NULL,\n"
                + AMOUNT + " integer,\n"
                + PRICES + " integer\n"
                + ");";
        try {
            Statement statement = db.getConnection().createStatement();
            statement.execute(SQL_CREATE_TABLE_STAFF);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void insertStaff(Product product) {
        Database db = new Database();
        final String SQL_CREATE_STUDENT = "INSERT INTO " + TABLE_NAME + "(" + PRODUCT_NAME + ", " + AMOUNT + "," + PRICES + ")" +
                "VALUES(?,?,?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_CREATE_STUDENT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getFullName());
            ps.setInt(2, product.getAmount());
            ps.setInt(3, product.getPrices());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                product.setID(id);
                System.out.println("Inserted id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public List<Product> getAllStaff() {
        List<Product> products = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM " + TABLE_NAME;
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_STUDENT_BY_ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                int amount = rs.getInt(3);
                int prices = rs.getInt(4);
                products.add(new Product(id, fullName, amount, prices));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return products;
    }

    @Override
    public List<Product> getAllStaffByName(String name) {
        List<Product> products = new Vector<>();

        Database db = new Database();

        final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM " + TABLE_NAME + " Where " + PRODUCT_NAME + " like ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_STUDENT_BY_ID);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                int amount = rs.getInt(3);
                int prices = rs.getInt(4);
                products.add(new Product(id, fullName, amount, prices));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return products;
    }

    @Override
    public Product getStaffByID(int ID) {
        Product product = null;

        Database db = new Database();

        final String SQL_SELECT_STAFF = "SELECT * FROM " + TABLE_NAME + " WHERE id=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT_STAFF);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt(1);
                String fullName = rs.getString(2);
                int amount = rs.getInt(3);
                int prices = rs.getInt(4);
                product = new Product(id, fullName, amount, prices);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return product;
    }

    @Override
    public void updateStaff(Product product) {

        Database db = new Database();
        final String SQL_UPDATE_STAFF = "UPDATE " + TABLE_NAME + " SET " + PRODUCT_NAME + " = ?, " + AMOUNT + "=?, " + PRICES + "=? " +
                "WHERE " + ID + "=?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_STAFF);
            ps.setString(1, product.getFullName());
            ps.setInt(2, product.getAmount());
            ps.setInt(3, product.getPrices());
            ps.setInt(4, product.getID());
            int result = ps.executeUpdate();
            System.out.println(result + " staff update");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }

    @Override
    public void deleteStaff(int index) {
        Database db = new Database();
        final String SQL_DELETE_STAFF = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = ?";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE_STAFF);
            ps.setInt(1, index);
            int result = ps.executeUpdate();
            System.out.println(result + " staff delete");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
    }
}
