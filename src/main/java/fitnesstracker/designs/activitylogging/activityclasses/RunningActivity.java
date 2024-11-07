package fitnesstracker.designs.activitylogging.activityclasses;

import fitnesstracker.designs.caloriescalculator.calorieclasses.RunningCalorieStrategy;

public class RunningActivity extends ActivityBase {
    public RunningActivity(int duration, int intensity) {
        super("Running", duration, intensity, new RunningCalorieStrategy());
    }
}