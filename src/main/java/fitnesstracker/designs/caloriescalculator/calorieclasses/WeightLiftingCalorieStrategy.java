package fitnesstracker.designs.caloriescalculator.calorieclasses;

import fitnesstracker.designs.caloriescalculator.CalorieCalculationStrategy;

public class WeightLiftingCalorieStrategy implements CalorieCalculationStrategy {
    @Override
    public int calculateCalories(int weight, int duration) {
        // Formula: 0.0175 * MET (Weight Lifting = 6) * weight (kg) * duration (minutes)
        return (int) (0.0175 * 6 * weight * duration);
    }
}
