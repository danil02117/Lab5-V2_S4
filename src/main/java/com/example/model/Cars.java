package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cars
{
    private Database database;

    public static final String DB_URL = "jdbc:mysql://localhost:3306/cars";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "root";

    public List<Car> getCars() throws SQLException
    {
        List<Car> carsList = new ArrayList<>();

        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        ResultSet resultSet = database.executeQuery("SELECT id, brand, model, year, mileage, color, price FROM cars");
        while (resultSet.next())
        {
            carsList.add(new Car(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getInt(7)
            ));
        }

        return carsList;
    }

    public void addCar(Car car) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("INSERT INTO cars (brand, model, year, mileage, color, price) " +
                        "VALUES ('%s', '%s', %d, %d, '%s', %d)",
                        car.getBrand(), car.getModel(), car.getYear(), car.getMileage(), car.getColor(), car.getPrice()));

        database.closeConnection();
    }

    public void removeCarById(int carId) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("DELETE FROM cars WHERE id=%d", carId));

        database.closeConnection();
    }

    public void updateCarById(int carId, Car newCar) throws SQLException
    {
        database = new Database(DB_URL, DB_LOGIN, DB_PASSWORD);

        database.executeQuery(String.format("UPDATE cars SET brand='%s', model='%s', year=%d, mileage=%d, color='%s', price=%d " +
                        "WHERE id=%d",
                newCar.getBrand(), newCar.getModel(), newCar.getYear(), newCar.getMileage(), newCar.getColor(), newCar.getPrice(), carId));

        database.closeConnection();
    }
}
