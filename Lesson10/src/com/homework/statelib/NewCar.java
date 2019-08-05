package com.homework.statelib;

/**
 * Created by Alexander Zolotarev on 03.08.2019.
 */
public class NewCar extends Car {

    public boolean IsCanAddAdditionalOptions;

    public NewCar(String _vehicleIdentificationNumber, String _brand, String _model,
                  CarTransmissionType carTransmissionType, CarEngineType carEngineType,
                  boolean isCanAddAdditionalOptions)
    {
        super(_vehicleIdentificationNumber, _brand, _model, carTransmissionType, carEngineType);
        IsCanAddAdditionalOptions = isCanAddAdditionalOptions;
    }
}
