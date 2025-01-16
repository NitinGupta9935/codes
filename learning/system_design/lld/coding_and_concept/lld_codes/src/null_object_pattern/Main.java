package null_object_pattern;

public class Main {

    public static void main(String args[]) {

        Vehicle vehicle = VehicleFactory.getVehicleObject("Car");
        vehicle = VehicleFactory.getVehicleObject("Car");
        vehicle = VehicleFactory.getVehicleObject("Bike");

        System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
        System.out.println("Seating Capacity: " + vehicle.getTankCapacity());


    }

    private static void printVehicleDetails(Vehicle vehicle) {

        if (vehicle != null) {
            System.out.println("Seating Capacity: " + vehicle.getSeatingCapacity());
            System.out.println("Seating Capacity: " + vehicle.getTankCapacity());
        }
    }

}
