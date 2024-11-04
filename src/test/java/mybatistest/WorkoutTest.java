package mybatistest;

import fitnesstracker.model.Workout;
import fitnesstracker.service.WorkoutService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WorkoutTest {

    private Workout workout;
    private WorkoutService workoutService;

    @Before
    public void setUp() {
        workoutService = new WorkoutService();
        workout = new Workout( "Running", "cardio");
        workoutService.create(workout);
    }

    @Test
    public void testCreateWorkout() {
        Workout dbWorkout = workoutService.findById(workout.getWorkoutId());
        assert workout.equals(dbWorkout);
    }

    @Test
    public void testUpdateWorkout() {
        Workout updatedWorkout = new Workout(workout.getWorkoutId(), "Swimming", "cardio");
        workoutService.update(updatedWorkout);
        Workout dbWorkout = workoutService.findById(workout.getWorkoutId());
        assert updatedWorkout.equals(dbWorkout);
    }

    @Test
    public void testDeleteWorkout() {
        workoutService.delete(workout.getWorkoutId());
        Workout dbWorkout = workoutService.findById(workout.getWorkoutId());
        assert dbWorkout == null;
    }

    @After
    public void tearDown() {
        workoutService.delete(workout.getWorkoutId());
    }
}

