package strategy_pattern;

import strategy_pattern.strategy.SportDriveStrategy;

public class SportsVehicle extends Vehicle{

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
