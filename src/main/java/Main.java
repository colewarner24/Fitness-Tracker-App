import fitnesstracker.designs.activitylogging.ActivityLogger;
import fitnesstracker.designs.progresstracking.ProgressTracker;
import fitnesstracker.designs.userprofilemanagement.UserProfile;
import fitnesstracker.designs.userprofilemanagement.UserProfileManager;
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
        profile.createProfile();
        profile.updateProfile();
        profile.getProfile();

        //Activity - Calories Calculator - Progress tracking update
        ActivityLogger activityLogger = new ActivityLogger();
        activityLogger.logActivity(); // TODO ProgressTracker parameters in the logActivity method needs to be fixed to match the DB
        activityLogger.getUserActivities(1); // TODO this should output a list of activities | TODO make method getActivitiesByUserId()

        // Progress Tracking
        ProgressTracker progressTracker = new ProgressTracker();
        System.out.println(progressTracker.getProgress());
    }
}
