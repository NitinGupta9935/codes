package adapter_pattern.adapter;

import adapter_pattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double WeightInKg() {
        double weighInPound = weightMachine.getWeightInPound();

        // convert it to KGs
        double weightInKg = weighInPound * .45;
        return weightInKg;
    }
}
