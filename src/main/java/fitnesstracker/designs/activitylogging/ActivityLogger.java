package fitnesstracker.designs.activitylogging;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.progresstracking.ProgressTracker;
import fitnesstracker.model.Activity;
import fitnesstracker.service.ActivityService;
import fitnesstracker.service.UserService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ActivityLogger implements IActivityLogger {
    private final Scanner scanner = new Scanner(System.in);
    private int workoutId;

    @Override
    public void logActivity() {
        System.out.println("\n*** Log Activity ***\n");

        // Get activity type and workout ID
        String activityType = getActivityType();

        // Get duration
        int duration = getIntInput("Enter duration in minutes: ");

        // Get intensity and set intensity level
        int intensity = getIntInput("Enter intensity (1-10): ", 1, 10);
        String intensityLevel = switch (intensity) {
            case 1, 2, 3 -> "Low";
            case 4, 5, 6, 7, 8 -> "Medium";
            case 9, 10 -> "High";
            default -> throw new IllegalArgumentException("Invalid intensity level");
        };

        // Get weight
        int weight = getIntInput("Enter your weight in kg: ");

        // Get user ID
        int userId;
        while (true) {
            userId = getIntInput("Enter your profile ID: ");
            if (new UserService().findById(userId) != null) {
                break; // Exit loop if user ID is valid
            } else {
                System.out.println("User ID not found. Please enter a valid user ID.");
            }
        }

        // Create Activity instance using the factory
        ActivityBase activityBase = ActivityFactory.createActivity(activityType, duration, intensity);

        // Calculate calories burned
        float caloriesBurned = activityBase.calculateCalories(weight);

        // Create and log Activity object
        Activity activity = new Activity();
        activity.setUserId(userId);
        activity.setWorkoutId(workoutId);
        activity.setDuration(duration);
        activity.setIntensity(intensityLevel);
        activity.setCaloriesBurned(caloriesBurned);
        activity.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        new ActivityService().create(activity);

        // Log details to the console
        System.out.printf("\nActivity Log:\nActivity Type: %s\nDuration: %d minutes\nIntensity: %d (%s)\nCalories Burned: %.2f\nWeight: %d kg\n",
                capitalize(activityType), duration, intensity, intensityLevel, caloriesBurned, weight);

        new ProgressTracker().updateOrCreateProgress(userId, (int) caloriesBurned, 0, 0, 0, 0);
    }

    @Override
    public List<Activity> getUserActivities() {
        System.out.print("\n*** Retrieving all user's Activities ***\nEnter user Id: ");
        int userId;
        while (true) {
            userId = getIntInput("Enter your profile ID: ");
            if (new UserService().findById(userId) != null) {
                break; // Exit loop if user ID is valid
            } else {
                System.out.println("User ID not found. Please enter a valid user ID.");
            }
        }
        return new ActivityService().findByUserId(userId);
    }

    private String getActivityType() {
        while (true) {
            System.out.print("Please select a number for the activity option:\n(1) Running\n(2) Cycling\n(3) Weight Lifting\nInput option: ");
            workoutId = getIntInput("");

            // Validate input and set activity type based on workoutId
            switch (workoutId) {
                case 1 -> {
                    return "running";
                }
                case 2 -> {
                    return "cycling";
                }
                case 3 -> {
                    return "weight lifting";
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        return input;
    }

    private int getIntInput(String prompt, int min, int max) {
        int input;
        do {
            input = getIntInput(prompt);
            if (input < min || input > max) {
                System.out.printf("Please enter a number between %d and %d.\n", min, max);
            }
        } while (input < min || input > max);
        return input;
    }

    private String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
