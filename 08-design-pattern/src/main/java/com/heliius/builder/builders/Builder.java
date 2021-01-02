package com.heliius.builder.builders;

import com.heliius.builder.cars.CarType;
import com.heliius.builder.components.Engine;
import com.heliius.builder.components.GPSNavigator;
import com.heliius.builder.components.Transmission;
import com.heliius.builder.components.TripComputer;


/**
 * @Author jcf
 * @Create 2020-10-30-12:07 上午
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
