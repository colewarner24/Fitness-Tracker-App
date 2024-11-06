import fitnesstracker.designs.activitylogging.ActivityLogger;
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
        ActivityLogger activityLogger = new ActivityLogger();
        activityLogger.logActivity();
    }
}
