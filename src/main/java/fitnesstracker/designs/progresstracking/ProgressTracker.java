package fitnesstracker.designs.progresstracking;

import fitnesstracker.model.Progress;
import fitnesstracker.service.ProgressService;

import java.util.Scanner;

public class ProgressTracker {
    private final Scanner scanner = new Scanner(System.in);

    public Progress getProgress() {
        System.out.println("\n*** Retrieve User Progress ***\n");
        System.out.print("Insert user id to retrieved: ");
        int userId = Integer.parseInt(scanner.nextLine());

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
            System.out.println("\n*** Create New Progress ***\n");
            progress = new Progress();
            progress.setUserId(userId);
        } else {
            System.out.println("\n*** Update Progress ***\n");
        }

        // Common updates for both existing and new progress
        progress.setTotalCaloriesBurned(progress.getTotalCaloriesBurned() + additionalCalories);
        progress.setTotalDistance(progress.getTotalDistance() + additionalDistance);
        progress.setWorkoutsCompleted(progress.getWorkoutsCompleted() + additionalWorkouts);
        progress.setWeeklyWorkoutGoal(weeklyWorkoutGoal);
        progress.setWeightGoal(weightGoal);
        progress.setLastUpdated(String.valueOf(System.currentTimeMillis()));

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
