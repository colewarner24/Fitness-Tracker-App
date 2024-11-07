package fitnesstracker.designs.progresstracking;

import fitnesstracker.model.Progress;
import fitnesstracker.service.ProgressService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ProgressTracker {

    public Progress getProgress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** Retrieving User Progress ***\n");
        System.out.print("Insert user id to retrieved: ");
        int userId = Integer.parseInt(scanner.nextLine());
        scanner.close();

        return new ProgressService().findById(userId); // TODO make method getProgressByUserId()
    }

    public void updateOrCreateProgress(int userId,
                                       int additionalCalories,
                                       float additionalDistance,
                                       int additionalWorkouts,
                                       int weeklyWorkoutGoal,
                                       float weightGoal) {
        ProgressService progressService = new ProgressService();
        Progress progress = progressService.findById(userId); // TODO make method getProgressByUserId()

        boolean isNewProgress = (progress == null);

        if (isNewProgress) {
            System.out.println("\n*** Creating New Progress Tracker ***\n");
            progress = new Progress();
            progress.setUserId(userId);
        } else {
            System.out.println("\n*** Updating Progress Tracker ***\n");
        }

        // Common updates for both existing and new progress
        progress.setTotalCaloriesBurned(progress.getTotalCaloriesBurned() + additionalCalories);
        progress.setTotalDistance(progress.getTotalDistance() + additionalDistance);
        progress.setWorkoutsCompleted(progress.getWorkoutsCompleted() + additionalWorkouts);
        progress.setWeeklyWorkoutGoal(weeklyWorkoutGoal);
        progress.setWeightGoal(weightGoal);
        progress.setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));

        // Save the progress (create if new, otherwise update)
        if (isNewProgress) {
            progressService.create(progress);
            System.out.println("New progress created: " + progress);
        } else {
            progressService.update(progress);
            System.out.println("Progress updated: " + progress);
        }
    }
}
