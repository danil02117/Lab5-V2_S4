package com.example.controller;

import com.example.model.Car;
import com.example.model.Cars;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/edit"})
public class EditionServlet extends HttpServlet
{
    private final Cars cars = new Cars();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        int carId = Integer.parseInt(req.getParameter("carId"));

        try
        {
            cars.updateCarById(carId, new Car(
                    "updated brand",
                    "updated model",
                    2000,
                    500,
                    "updated color",
                    250
            ));


            updatePage(req, resp);
        }
        catch (SQLException e)
        {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ошибка базы данных: " + e.getMessage());
        }
    }

    private void updatePage(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException
    {
        List<Car> carsList = cars.getCars();
        req.setAttribute("carsList", carsList);

        req.getRequestDispatcher("view/index.jsp").forward(req, resp);
    }
}
