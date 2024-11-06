package fitnesstracker.designs.activitylogging;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.progresstracking.ProgressTracker;
import fitnesstracker.model.Activity;
import fitnesstracker.service.ActivityService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ActivityLogger implements IActivityLogger {
    String activityType;
    int workoutId;
    int intensity;
    String intensityLevel;

    @Override
    public void logActivity() {

        Scanner scanner = new Scanner(System.in);

        // Ask user for activity type
        while (true) {
            System.out.println("\n*** Log Activity ***\n");
            System.out.print("Enter activity type (running, cycling, weight lifting): ");
            activityType = scanner.nextLine().toLowerCase();

            try {
                switch (activityType) {
                    case "running" -> workoutId = 1;
                    case "cycling" -> workoutId = 2;
                    case "weight lifting" -> workoutId = 3;
                    default -> {
                        System.out.println("choose a valid option (running, cycling, weight lifting)");
                        continue; // Restart the loop if input is invalid
                    }
                }
                break; // Exit the loop if a valid intensity level was set
            } catch (IllegalArgumentException e) {
                System.out.println("choose a valid option (running, cycling, weight lifting)");
            }
        }

        // Ask user for activity duration
        System.out.print("Enter duration in minutes: ");
        int duration = Integer.parseInt(scanner.nextLine());

        // Ask user for activity intensity
        // Needs a loop to validate a range and add a String value to intensityLevel which is used for model DB requirement
        while (true) {
            System.out.print("Enter intensity (1-10): ");
            int intensity = Integer.parseInt(scanner.nextLine());

            try {
                switch (intensity) {
                    case 1, 2, 3 -> intensityLevel = "Low";
                    case 4, 5, 6, 7, 8 -> intensityLevel = "Medium";
                    case 9, 10 -> intensityLevel = "High";
                    default -> {
                        System.out.println("Intensity must be between 1 and 10");
                        continue; // Restart the loop if input is invalid
                    }
                }
                break; // Exit the loop if a valid intensity level was set
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid number between 1 and 10.");
            }
        }

        // Ask user for weight
        System.out.print("Enter your weight in kg: ");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter your profile ID: ");
        int userId = Integer.parseInt(scanner.nextLine());

        // Create the appropriate Activity instance using the factory
        ActivityBase activitybase = ActivityFactory.createActivity(activityType, duration, intensity);

        // Calculate the calories burned
        float caloriesBurned = activitybase.calculateCalories(weight);

        // Create Activity Object to log at DB
        Activity activity = new Activity();
        activity.setUserId(userId);
        activity.setWorkoutId(workoutId);
        activity.setDuration(duration);
        activity.setIntensity(intensityLevel);
        activity.setCaloriesBurned(caloriesBurned);
        activity.setTimestamp(LocalDateTime.now());

        //Log at DB
        new ActivityService().create(activity);

        // Log the details to the console
        System.out.println("\nActivity Log:");
        System.out.println("Activity Type: " + activityType.substring(0, 1).toUpperCase() + activityType.substring(1));
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Intensity: " + intensity);
        System.out.println("Calories Burned: " + caloriesBurned);
        System.out.println("Weight: " + weight + " kg");

        // Closing scanner
        scanner.close();

        new ProgressTracker().updateOrCreateProgress(userId, (int) caloriesBurned, 0, 0, 0, 0);
    }

    @Override
    public List<Activity> getUserActivities(int userId) {
        return new ActivityService().findByUserId(userId); // TODO make method getActivitiesByUserId()
    }
}
