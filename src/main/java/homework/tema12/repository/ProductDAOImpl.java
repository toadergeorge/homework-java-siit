package homework.tema12.repository;

import homework.tema12.entity.Product;
import homework.tema12.exception.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductRepository{
    @Override
    public void save(Product product) {
        String query = "" +
                "INSERT INTO " +
                "   products(productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP) " +
                "   VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);

        int rowsAffected = 0;
        try {
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
            preparedStatement.setDouble(8, product.getBuyPrice());
            preparedStatement.setDouble(9, product.getMSRP());
            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Eror while inserting product!");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Product " + product + " was inserted successfuly");
        }
    }

    @Override
    public List<Product> findByProductCode(String productCode) {

        String query = "select productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP\n" +
                "from products p\n" +
                "where p.productCode = ?";

        PreparedStatement ps = getPreparedStatement(query);
        List<Product> products = new ArrayList<>();

        try {
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Product product = extractProductFromResultSet(rs);
                products.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving product with code: " + productCode);
            throw new DatabaseException(e);
        }

        return products;
    }

    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        return Product.builder()
                .productCode(rs.getString("productCode"))
                .productName(rs.getString("productName"))
                .productLine(rs.getString("productLine"))
                .productScale(rs.getString("productScale"))
                .productVendor(rs.getString("productVendor"))
                .productDescription(rs.getString("productDescription"))
                .quantityInStock(rs.getInt("quantityInStock"))
                .buyPrice(rs.getDouble("buyPrice"))
                .MSRP(rs.getDouble("MSRP"))
                .build();
    }

    @Override
    public void update(Product product) {
        PreparedStatement preparedStatement = getPreparedStatement(
                "UPDATE products SET " +
                        "productCode = ?, " +
                        "productName = ?," +
                        "productLine =?, " +
                        "productScale = ?," +
                        "productVendor =?, " +
                        "productDescription =?, " +
                        "quantityInStock =?, " +
                        "buyPrice =?, " +
                        "MSRP =? " +
                        "WHERE productCode = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setDouble(7, product.getQuantityInStock());
            preparedStatement.setDouble(8, product.getBuyPrice());
            preparedStatement.setDouble(9, product.getMSRP());

            preparedStatement.setString(10, product.getProductCode());

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating product");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Product with productCode " + product.getProductCode() + " was updated successfuly");
        }
    }

    @Override
    public void delete(String productCode) {
        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM products WHERE productCode = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setString(1, productCode);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while deleting product");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Product with code " + productCode + " was deleted successfuly");
        } else {
            System.out.println("Product with code " + productCode + " was not deleted!");
        }
    }

    private PreparedStatement getPreparedStatement(String query) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?serverTimezone=EET",
                    "root",
                    "geo711490rge");
            return connection.prepareStatement(query);
        } catch (SQLException throwable) {
            System.out.println("Error while getting connection");
            throw new RuntimeException("Error while getting connection", throwable);
        }
    }
}
