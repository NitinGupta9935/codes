package strategy_pattern;

import strategy_pattern.strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new SportDriveStrategy());
    }
}
