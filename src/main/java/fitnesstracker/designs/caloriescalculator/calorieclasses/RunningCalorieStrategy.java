package fitnesstracker.designs.caloriescalculator.calorieclasses;

import fitnesstracker.designs.caloriescalculator.CalorieCalculationStrategy;

public class RunningCalorieStrategy implements CalorieCalculationStrategy {
    @Override
    public int calculateCalories(int weight, int duration) {
        // Formula: 0.0175 * MET (Running = 10) * weight (kg) * duration (minutes)
        return (int) (0.0175 * 10 * weight * duration);
    }
}
