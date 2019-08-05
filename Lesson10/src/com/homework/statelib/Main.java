package com.homework.statelib;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarDealer dealer = new CarDealer();
        Car bwmZ4 = new UsedCar("4USBT53544LT26841", "BMW", "Z4", Car.CarTransmissionType.Automatic,
                Car.CarEngineType.Diesel, true, false, 37850);
        dealer.addCar(bwmZ4);

        Car mercedesGl = new UsedCar("4JGBF71E47A278782", "MERCEDES", "GL 450 4Matic", Car.CarTransmissionType.Automatic,
                Car.CarEngineType.Petrol, false, false, 14276);
        dealer.addCar(mercedesGl);

        //for new cars

        ArrayList<Car> cars = dealer.getNewCars();
        for(Car car : cars)
        {
            car.printInfo();
        }
        Car.printCarsByBrand("BMW", cars);
        Car.printCarsByBrandAndModel("BMW","Z4",cars);
        Car.printCarsByEngineType(Car.CarEngineType.Diesel, cars);
        Car.printCarsByTransmissionType(Car.CarTransmissionType.Automatic, cars);
        Car.printCarDublicates(2,cars);

        //for used cars
        cars = dealer.getUsedCars();
        for(Car car : cars)
        {
            car.printInfo();
        }
        Car.printCarsByBrand("BMW", cars);
        Car.printCarsByBrandAndModel("BMW","Z4",cars);
        Car.printCarsByEngineType(Car.CarEngineType.Diesel, cars);
        Car.printCarsByTransmissionType(Car.CarTransmissionType.Automatic, cars);
        Car.printCarDublicates(2,cars);

    }



    public static Car CreateCar()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите VIN номер автомобиля (17 символов)");
        String vin = s.nextLine();
        System.out.println("Введите Марку автомобиля");
        String brand = s.nextLine();
        System.out.println("Введите Модель автомобиля");
        String model = s.nextLine();
        System.out.println("Выберите тип трансмиссии автомобиля:");
        System.out.println("1. Автоматическая");
        System.out.println("2. Механическая");
        int transmissionValue = s.nextInt();
        Car.CarTransmissionType transmission =  Car.CarTransmissionType.Automatic;
        switch (transmissionValue) {
            case 1:
                transmission = Car.CarTransmissionType.Automatic;
                break;
            case 2:
                transmission = Car.CarTransmissionType.Manual;
                break;
        }

        System.out.println("Выберите тип двигателя автомобиля:");
        System.out.println("1. Дизельный");
        System.out.println("2. Бензиновый");
        System.out.println("3. Газовый");
        System.out.println("4. Электрический");
        int engineValue = s.nextInt();
        Car.CarEngineType engine = Car.CarEngineType.Diesel;
        switch (engineValue) {
            case 1:
                engine = Car.CarEngineType.Diesel;
                break;
            case 2:
                engine = Car.CarEngineType.Petrol;
                break;
            case 3:
                engine = Car.CarEngineType.Gas;
                break;
            case 4:
                engine = Car.CarEngineType.Electrical;
                break;
        }

        System.out.println("Перекрашивался ли автомобиль?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int answerRepaint = s.nextInt();
        boolean isRepainted = false;
        switch (answerRepaint) {
            case 1:
                isRepainted = true;
                break;
            case 2:
                isRepainted = false;
                break;
        }

        System.out.println("Были ли аварии?");
        System.out.println("1. Да");
        System.out.println("2. Нет");
        int answerCrashed = s.nextInt();
        boolean isCrashed = false;
        switch (answerCrashed) {
            case 1:
                isCrashed = true;
                break;
            case 2:
                isCrashed = false;
                break;
        }

        System.out.println("Введите пробег автомобиля");
        int miles = s.nextInt();

        Car car = new UsedCar(vin,brand,model, transmission, engine, isRepainted, isCrashed, miles);
        return  car;
    }
}

