package fitnesstracker.designs.caloriescalculator.calorieclasses;

import fitnesstracker.designs.caloriescalculator.CalorieCalculationStrategy;

public class CyclingCalorieStrategy implements CalorieCalculationStrategy {
    @Override
    public int calculateCalories(int weight, int duration) {
        // Formula: 0.0175 * MET (Cycling = 8) * weight (kg) * duration (minutes)
        return (int) (0.0175 * 8 * weight * duration);
    }
}