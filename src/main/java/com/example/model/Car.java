package com.example.model;

public class Car
{
    private int id;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String color;
    private int price;

    public Car(int id, String brand, String model, int year, int mileage, String color, int price)
    {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.color = color;
        this.price = price;
    }

    public Car(String brand, String model, int year, int mileage, String color, int price)
    {
        this(-1, brand, model, year, mileage, color, price);
    }


    public int getId()
    {
        return id;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }

    public int getMileage()
    {
        return mileage;
    }

    public String getColor()
    {
        return color;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (year != car.year) return false;
        if (mileage != car.mileage) return false;
        if (price != car.price) return false;
        if (!brand.equals(car.brand)) return false;
        if (!model.equals(car.model)) return false;
        return color.equals(car.color);
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        result = 31 * result + mileage;
        result = 31 * result + color.hashCode();
        result = 31 * result + price;
        return result;
    }
}
