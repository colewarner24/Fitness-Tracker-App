package fitnesstracker.designs.activitylogging.activityclasses;

import fitnesstracker.designs.caloriescalculator.calorieclasses.CyclingCalorieStrategy;

public class CyclingActivity extends ActivityBase {
    public CyclingActivity(int duration, int intensity) {
        super("Cycling", duration, intensity, new CyclingCalorieStrategy());
    }
}