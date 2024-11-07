package mybatistest;

import fitnesstracker.model.Activity;
import fitnesstracker.model.User;
import fitnesstracker.model.Workout;
import fitnesstracker.service.ActivityService;
import fitnesstracker.service.UserService;
import fitnesstracker.service.WorkoutService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ActivityTest {

    private User user;
    private Workout workout;
    private Activity activity;
    private UserService userService;
    private WorkoutService workoutService;
    private ActivityService activityService;

    @Before
    public void setUp() {
        userService = new UserService();
        workoutService = new WorkoutService();
        activityService = new ActivityService();

        user = new User("user1", "password", "John Doe", 25, 130.5f, 180.0f, "muscle_growth");
        userService.create(user);

        workout = new Workout("Cycling", "Cardio");
        workoutService.create(workout);

        activity = new Activity(user.getUserId(), workout.getWorkoutId(), 45, "medium", 350.0f, "2024-11-04 10:00:00");
        activityService.create(activity);
    }

    @Test
    public void testCreateActivity() {
        Activity dbActivity = activityService.findById(activity.getActivityId());
        assert activity.equals(dbActivity);
    }

    @Test
    public void testUpdateActivity() {
        Activity updatedActivity = new Activity(activity.getActivityId(), user.getUserId(), workout.getWorkoutId(), 60, "high", 500.0f, "2024-11-04 11:00:00");
        activityService.update(updatedActivity);
        Activity dbActivity = activityService.findById(activity.getActivityId());
        assert updatedActivity.equals(dbActivity);
    }

    @Test
    public void testFindActivityByUserId() {
        List<Activity> activities = activityService.findByUserId(user.getUserId());
        assert activities.size() == 1;
        assert activities.get(0).equals(activity);
    }

    @Test
    public void testDeleteActivity() {
        activityService.delete(activity.getActivityId());
        Activity dbActivity = activityService.findById(activity.getActivityId());
        assert dbActivity == null;
    }


    @After
    public void tearDown() {
        activityService.delete(activity.getActivityId());
        workoutService.delete(workout.getWorkoutId());
        userService.delete(user.getUserId());
    }
}
