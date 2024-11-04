package fitnesstracker.designs.activitylogging;

import java.util.List;

public interface IActivityLogger {
    void logActivity(Activity activity);
    List<Activity> getUserActivities(int userId);
}
