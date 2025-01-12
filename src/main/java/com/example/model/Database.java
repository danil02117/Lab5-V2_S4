package com.example.model;

import java.sql.*;

public class Database
{
    private final Connection connection;

    public Database(String url, String user, String password) throws SQLException
    {

        connection = DriverManager.getConnection(
    "jdbc:mariadb://localhost:3306/database_name",
    "user", "password"
);
        if (connection.isClosed())
            throw new SQLException("Connection is closed");
    }

    /**
     * @return Если запрос может вернуть ResultSet, то возвращает его, если запрос статический - возвращает null.
     */
    public ResultSet executeQuery(String sqlQuery) throws SQLException
    {
        Statement statement = connection.createStatement();
        boolean isResultSet = statement.execute(sqlQuery);

        if (isResultSet)
            return statement.executeQuery(sqlQuery);

        return null;
    }

    public void closeConnection() throws SQLException
    {
        if (!connection.isClosed())
            connection.close();
    }


}
