package fitnesstracker.designs.activitylogging;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.model.Activity;

import java.util.List;

public interface IActivityLogger {
    void logActivity();
    List<Activity> getUserActivities();
}