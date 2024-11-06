package fitnesstracker.designs.activitylogging.activityclasses;

import fitnesstracker.designs.caloriescalculator.CalorieCalculationStrategy;

public abstract class ActivityBase {
    protected String type;
    protected int duration; // in minutes
    protected int intensity; // scale from 1 to 10
    protected int caloriesBurned;
    protected CalorieCalculationStrategy calorieCalculationStrategy;

    public ActivityBase(String type, int duration, int intensity, CalorieCalculationStrategy calorieCalculationStrategy) {
        this.type = type;
        this.duration = duration;
        this.intensity = intensity;
        this.calorieCalculationStrategy = calorieCalculationStrategy;
    }

    // Method to calculate calories using the appropriate strategy
    public int calculateCalories(int weight) {
        return calorieCalculationStrategy.calculateCalories(weight, duration);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}