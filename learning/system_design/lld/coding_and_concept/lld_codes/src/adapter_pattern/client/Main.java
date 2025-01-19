package adapter_pattern.client;

import adapter_pattern.adaptee.WeightMachineForBabies;
import adapter_pattern.adapter.WeightMachineAdapter;
import adapter_pattern.adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main() {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.WeightInKg());
    }
}
