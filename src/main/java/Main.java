import fitnesstracker.designs.activitylogging.ActivityLogger;
import fitnesstracker.designs.notifications.NotificationManager;
import fitnesstracker.designs.progresstracking.ProgressTracker;
import fitnesstracker.designs.userprofilemanagement.UserProfile;
import fitnesstracker.designs.userprofilemanagement.UserProfileManager;
import fitnesstracker.model.User;
import fitnesstracker.model.Workout;
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
        User currentUser = profile.createProfile();
        currentUser = profile.updateProfile();
        profile.getProfile();

        //Activity - Calories Calculator - Progress tracking update
        ActivityLogger activityLogger = new ActivityLogger();
//        activityLogger.logActivity(); // TODO ProgressTracker parameters in the logActivity method needs to be fixed to match the DB
        System.out.println(activityLogger.getUserActivities()); // TODO this should output a list of activities | TODO make method getActivitiesByUserId()

        // Progress Tracking
        System.out.println(new ProgressTracker().getProgress());

        // Notifications
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.sendDailyNotification(currentUser);

    }
}
