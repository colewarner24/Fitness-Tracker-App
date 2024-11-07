package fitnesstracker.designs.activitylogging.activityclasses;

import fitnesstracker.designs.caloriescalculator.calorieclasses.WeightLiftingCalorieStrategy;

public class WeightLiftingActivity extends ActivityBase {
    public WeightLiftingActivity(int duration, int intensity) {
        super("Weight Lifting", duration, intensity, new WeightLiftingCalorieStrategy());
    }
}