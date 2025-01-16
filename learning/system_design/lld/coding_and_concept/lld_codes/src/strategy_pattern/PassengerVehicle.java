package strategy_pattern;

import strategy_pattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{

    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
