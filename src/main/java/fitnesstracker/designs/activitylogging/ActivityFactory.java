package fitnesstracker.designs.activitylogging;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.activitylogging.activityclasses.CyclingActivity;
import fitnesstracker.designs.activitylogging.activityclasses.RunningActivity;
import fitnesstracker.designs.activitylogging.activityclasses.WeightLiftingActivity;

public class ActivityFactory {
    public static ActivityBase createActivity(String type, int duration, int intensity) {

        return switch (type.toLowerCase()) {
            case "running" -> new RunningActivity(duration, intensity);
            case "cycling" -> new CyclingActivity(duration, intensity);
            case "weight lifting" -> new WeightLiftingActivity(duration, intensity);
            default -> throw new IllegalArgumentException("Unknown activity type: " + type);
        };
    }
}
