package strategy_pattern;

import strategy_pattern.strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveObject;

    Vehicle(DriveStrategy driveObject) {
        this.driveObject = driveObject;
    }

    public void drive() {
        driveObject.drive();
    }
}
