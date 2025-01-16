package strategy_pattern;

import strategy_pattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
