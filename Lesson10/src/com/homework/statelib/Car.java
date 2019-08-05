package com.homework.statelib;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander Zolotarev on 03.08.2019.
 */
public abstract class Car {

    private String _vehicleIdentificationNumber;
    private String _brand;
    private String _model;
    public CarTransmissionType TransmissionType;
    public CarEngineType EngineType;

    public Car(String _vehicleIdentificationNumber, String _brand, String _model,
               CarTransmissionType carTransmissionType, CarEngineType carEngineType)
    {
        this._vehicleIdentificationNumber = _vehicleIdentificationNumber;
        this._brand = _brand;
        this._model = _model;
        TransmissionType = carTransmissionType;
        EngineType = carEngineType;
    }

    public enum CarTransmissionType
    {
        Automatic,
        Manual
    }

    public enum CarEngineType
    {
        Diesel,
        Petrol,
        Gas,
        Electrical
    }

    public String getVehicleIdentificationNumber()
    {
        return _vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber)
    {
        if(vehicleIdentificationNumber!=null) {
            if (vehicleIdentificationNumber.length() == 17) {
                this._vehicleIdentificationNumber = vehicleIdentificationNumber;
            } else {
                System.out.println("Vehicle Identification Number length should be equals to 17");
            }
        }
        else
        {
            System.out.println("Vehicle Identification Number can not be Null");
        }
    }

    public String getModel()
    {
        return _model;
    }

    public void setModel(String model)
    {
        if(model!=null && model!="")
        {
            this._model = model;
        }
        else
        {
            System.out.println("Model can not be Null or Empty");
        }
    }

    public String getBrand()
    {
        return _brand;
    }

    public void setBrand(String brand)
    {
        if(brand!=null && brand!="")
        {
            this._brand = brand;
        }
        else
        {
            System.out.println("Brand can not be Null or Empty");
        }
    }

    public void printInfo(){
        System.out.println("VIN: "+getVehicleIdentificationNumber());
        System.out.println("Brand: "+getBrand());
        System.out.println("Model: "+getModel());
        System.out.println("Transmission: "+TransmissionType);
        System.out.println("Engine: "+EngineType);
    }

    public static void printCarsByBrand(String brand, ArrayList<Car> cars)
    {
        for(Car car: cars)
        {
            if(car.getBrand() == brand){
                car.printInfo();
            }

        }
    }

    public static void  printCarsByModel(String model, ArrayList<Car> cars)
    {
        for(Car car: cars)
        {
            if(car.getModel() ==  model){
                car.printInfo();
            }

        }
    }

    public static void  printCarsByBrandAndModel(String brand, String model, ArrayList<Car> cars)
    {
        for(Car car: cars)
        {
            if(car.getBrand() == brand||car.getModel()==model){
                car.printInfo();
            }

        }
    }

    public static void  printCarsByEngineType(Car.CarEngineType engineType, ArrayList<Car> cars)
    {
        for(Car car: cars)
        {
            if(car.EngineType == engineType){
                car.printInfo();
            }

        }
    }

    public static void printCarsByTransmissionType(Car.CarTransmissionType transmissionType, ArrayList<Car> cars)
    {
        for(Car car: cars)
        {
            if(car.TransmissionType == transmissionType){
                car.printInfo();
            }

        }
    }

    public static void  printCarDublicates(int dublicatesCount, ArrayList<Car> cars)
    {
        Map<Car, Integer> dublicatesMap = new HashMap<Car, Integer>();

        for (Car car: cars) {
            if (dublicatesMap.containsKey(car)) {
                dublicatesMap.put(car, dublicatesMap.get(car) + 1);
            } else {
                dublicatesMap.put(car, 1);
            }
        }

        for (Map.Entry<Car, Integer> entry : dublicatesMap.entrySet())
        {
            if(entry.getValue()==dublicatesCount)
            {
                entry.getKey().printInfo();
            }
        }

    }

}
