package com.homework.statelib;


import java.util.ArrayList;

/**
 * Created by Alexander Zolotarev on 03.08.2019.
 */
public class CarDealer {
    private ArrayList<Car> _cars = new ArrayList<Car>();

    public final ArrayList<Car> getCars()
    {
        return _cars;
    }

    public void addCar(Car car)
    {
        if(car != null){
            _cars.add(car);
            System.out.println("Car added");
            return;
        }
        else
        {
            System.out.println("Car can not be Null");
            return;
        }
    }

    public ArrayList<Car> getUsedCars()
    {
        ArrayList<Car> cars = new ArrayList<Car>();
        for(Car car : getCars())
        {
            if(car.getClass().getName()=="UsedCar")
                cars.add(car);
        }
        return  cars;
    }

    public ArrayList<Car> getNewCars()
    {
        ArrayList<Car> cars = new ArrayList<Car>();
        for(Car car : getCars())
        {
            if(car.getClass().getName()=="NewCar")
                cars.add(car);
        }
        return  cars;
    }

    public void editCar(Car currentCar, Car editedCar)
    {
        if(currentCar != null && editedCar != null)
        {
            int currentCarIndex = _cars.indexOf(currentCar);
            if(currentCarIndex != -1)
            {
                _cars.set(currentCarIndex,editedCar);
                System.out.println("Replaced");
                return;
            }
            else
            {
                System.out.println("Current car not found");
                return;
            }
        }
        else
        {
            System.out.println("Input not Null values please");
            return;
        }
    }

    public void deleteCar(Car car) {
        if (car != null) {
            boolean removingResult = _cars.remove(car);
            if (removingResult == true) {
                System.out.println("Car successfully deleted");
                return;
            } else {
                System.out.println("Car not deleted");
                return;
            }
        } else {
            System.out.println("Car can not be null");
            return;
        }
    }
}
