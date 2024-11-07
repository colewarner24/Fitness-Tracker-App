import fitnesstracker.designs.activitylogging.ActivityLogger;
import fitnesstracker.designs.notifications.NotificationManager;
import fitnesstracker.designs.progresstracking.ProgressTracker;
import fitnesstracker.designs.userprofilemanagement.UserProfileManager;
import fitnesstracker.model.Workout;
import fitnesstracker.service.UserService;
import fitnesstracker.service.WorkoutService;

public class Main {

    // Static block to initialize Workout data
    static {
        WorkoutService workoutService = new WorkoutService();
        workoutService.create(new Workout("running", "cardio"));
        workoutService.create(new Workout("cycling", "cardio"));
        workoutService.create(new Workout("weight lifting", "strength"));
    }

    public static void main(String[] args) {

        // Profile
        UserProfileManager profile = new UserProfileManager();
        profile.createProfile();
        profile.updateProfile();
        profile.getProfile();

        //Activity - Calories Calculator - Progress tracking update
        ActivityLogger activityLogger = new ActivityLogger();
        activityLogger.logActivity();
        System.out.println(activityLogger.getUserActivities());

        // Progress Tracking
        System.out.println(new ProgressTracker().getProgress());

        // Notifications
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.sendDailyNotification(new UserService().findById(1));

    }
}