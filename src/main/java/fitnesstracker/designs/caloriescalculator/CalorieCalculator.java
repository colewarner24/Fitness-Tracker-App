package fitnesstracker.designs.caloriescalculator;

public class CalorieCalculator {
    private CalorieCalculationStrategy strategy;

    public void setCalculationStrategy(CalorieCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int weight, int duration) {
        return strategy.calculateCalories(weight, duration);
    }
}
