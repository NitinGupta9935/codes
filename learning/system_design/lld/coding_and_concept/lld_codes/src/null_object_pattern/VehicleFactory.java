package null_object_pattern;

public class VehicleFactory {

    static Vehicle getVehicleObject(String typeOfVehicle) {

        if ("Car".equals(typeOfVehicle))
            return new Car();
        else if ("Bus".equals(typeOfVehicle))
            return new Bus();

        return new NullVehicle();
    }
}


