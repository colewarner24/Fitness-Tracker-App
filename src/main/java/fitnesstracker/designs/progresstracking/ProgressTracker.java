package fitnesstracker.designs.progresstracking;

import fitnesstracker.model.Progress;
import fitnesstracker.service.ProgressService;
import fitnesstracker.service.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ProgressTracker {

    public Progress getProgress() {
        System.out.println("\n*** Retrieving User Progress ***\n");

        // Get valid user ID directly
        int userId = getValidatedUserId();

        // Retrieve and return progress for the valid user ID
        return new ProgressService().findByUserId(userId);
    }

    public void updateOrCreateProgress(int userId,
                                       int additionalCalories,
                                       float additionalDistance,
                                       int additionalWorkouts,
                                       int weeklyWorkoutGoal,
                                       float weightGoal) {
        ProgressService progressService = new ProgressService();
        Progress progress = progressService.findByUserId(userId);

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

    private int getValidatedUserId() {
        Scanner scanner = new Scanner(System.in);
        int userId;

        // Prompt for user ID with validation
        while (true) {
            System.out.print("Insert user id to retrieve: ");
            if (scanner.hasNextInt()) {
                userId = scanner.nextInt();
                if (new UserService().findById(userId) != null) {
                    break;  // Exit loop if user ID is valid
                } else {
                    System.out.println("User ID not found. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
        return userId;
    }
}
