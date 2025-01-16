package null_object_pattern;

public class Bus implements Vehicle {
    @Override
    public int getTankCapacity() {
        return 150;
    }

    @Override
    public int getSeatingCapacity() {
        return 2;
    }
}
