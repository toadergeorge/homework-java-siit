package homework.tema12.repository;

import homework.tema12.entity.Order;
import homework.tema12.entity.OrderStatus;
import homework.tema12.exception.DatabaseException;
import homework.tema12.service.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl extends DbConnection implements OrderRepository{
    @Override
    public void save(Order order) {
        String query = "" +
                "INSERT INTO " +
                "   orders(orderDate,requiredDate,shippedDate,status,comments,customerNumber,orderNumber) " +
                "   VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getPreparedStatement(query);

        int rowsAffected = 0;
        try {
            preparedStatement.setDate(1, Date.valueOf( order.getOrderDate()));
            preparedStatement.setDate(2, Date.valueOf( order.getRequireDate()));
            preparedStatement.setDate(3, Date.valueOf( order.getShippedDate()));
            preparedStatement.setString(4, order.getStatus().getName() );
            preparedStatement.setString(5, order.getComments());
            preparedStatement.setInt(6, order.getCustomerNumber());
            preparedStatement.setInt(7, order.getOrderNumber());

            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Eror while inserting order!");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order  " + order + " was inserted successfuly");
        }
    }

    @Override
    public List<Order> findByOrderNumber(int orderNumber) {

        String query = "select orderNumber,orderDate,requiredDate,shippedDate,status,comments,customerNumber\n" +
                "from orders o\n" +
                "where o.orderNUmber = ?";

        PreparedStatement ps = getPreparedStatement(query);
        List<Order> orders = new ArrayList<>();

        try {
            ps.setInt(1, orderNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = extractOrderFromResultSet(rs);
                orders.add(order);
            }

        } catch (SQLException e) {
            System.out.println("Error while retrieving order with number: " + orderNumber);
            throw new DatabaseException(e);
        }

        return orders;
    }

    private Order extractOrderFromResultSet(ResultSet rs) throws SQLException {
        return Order.builder()
                .orderNumber(rs.getInt("orderNumber"))
                .orderDate(rs.getDate("orderDate").toLocalDate())
                .requireDate(rs.getDate("requiredDate").toLocalDate())
                .shippedDate(rs.getDate("shippedDate").toLocalDate())
                .status(OrderStatus.fromString(rs.getString("status")))
                .comments(rs.getString("comments"))
                .customerNumber(rs.getInt("customerNumber"))
                .build();
    }

    @Override
    public void update(Order order) {
        PreparedStatement preparedStatement = getPreparedStatement(
                "UPDATE orders SET " +
                        "orderNumber = ?, " +
                        "orderDate = ?," +
                        "requiredDate =?, " +
                        "shippedDate = ?," +
                        "status =?, " +
                        "comments =?, " +
                        "customerNumber =? " +
                        "WHERE orderNumber = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setInt(1, order.getOrderNumber());
            preparedStatement.setDate(2, Date.valueOf(order.getOrderDate()));
            preparedStatement.setDate(3, Date.valueOf(order.getRequireDate()));
            preparedStatement.setDate(4, Date.valueOf(order.getShippedDate()));
            preparedStatement.setString(5, order.getStatus().getName());
            preparedStatement.setString(6, order.getComments());
            preparedStatement.setDouble(7, order.getCustomerNumber());
            preparedStatement.setInt(8, order.getOrderNumber());
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while updating order");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order with orderNumber " + order.getOrderNumber() + " was updated successfuly");
        }
    }

    @Override
    public void delete(int orderNumber) {
        PreparedStatement preparedStatement = getPreparedStatement("DELETE FROM orders WHERE orderNumber = ?");
        int rowsAffected = 0;

        try {
            preparedStatement.setInt(1, orderNumber);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Eror while deleting order");
            throw new DatabaseException(e);
        }

        if (rowsAffected > 0) {
            System.out.println("Order with number " + orderNumber + " was deleted successfuly");
        } else {
            System.out.println("Order with number " + orderNumber + " was not deleted!");
        }
    }
}
