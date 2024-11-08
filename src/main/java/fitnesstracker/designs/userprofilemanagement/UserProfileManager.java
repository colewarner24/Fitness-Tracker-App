package fitnesstracker.designs.userprofilemanagement;

import fitnesstracker.model.User;
import fitnesstracker.service.UserService;

import java.util.Scanner;

public class UserProfileManager implements IProfileManager {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public UserProfile getProfile() {

        System.out.println("\n*** Retrieve Profile ***\n");

        int userId = getValidatedUserId("Insert user id to retrieved: ");

        User user = userService.findById(userId);
        if (user != null) {
            UserProfile profile = new UserProfile();
            profile.setUser(user);
            System.out.println("Profile retrieved: " + user);
            return profile;
        } else {
            System.out.println("User not found with ID: " + userId);
            return null;
        }
    }

    @Override
    public void updateProfile() {
        System.out.println("\n*** Update Profile ***\n");
        int userId = getValidatedUserId("Enter user ID to update: ");

        User existingUser = userService.findById(userId);
        if (existingUser != null) {
            System.out.println("Updating profile for: " + existingUser);

            System.out.print("New Username (leave blank to keep unchanged): ");
            String newUsername = scanner.nextLine();
            if (!newUsername.isEmpty()) existingUser.setUsername(newUsername);

            System.out.print("New Password (leave blank to keep unchanged): ");
            String newPassword = scanner.nextLine();
            if (!newPassword.isEmpty()) existingUser.setPassword(newPassword);

            System.out.print("New Name (leave blank to keep unchanged): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) existingUser.setName(newName);

            // Update Age with validation
            int ageInput = getPositiveIntInputOrEmpty(scanner, "New Age (leave blank to keep unchanged): ");
            if (ageInput != -1) existingUser.setAge(ageInput);

            // Update Weight with validation
            float weightInput = getPositiveFloatInputOrEmpty(scanner, "New Weight (kg, leave blank to keep " +
                    "unchanged): ");
            if (ageInput != -1) existingUser.setWeight(weightInput);

            // Update Height with validation
            float heightInput = getPositiveFloatInputOrEmpty(scanner, "New Height (cm, leave blank to keep " +
                    "unchanged): ");
            if (ageInput != -1) existingUser.setHeight(heightInput);

            // Update Fitness Goal with validation
            String newFitnessGoal = getValidFitnessGoalOrEmpty(scanner, "New Fitness Goal (conditioning, " +
                    "weight_loss, muscle_growth,  or leave blank to keep unchanged): ");
            if (!newFitnessGoal.isEmpty()) existingUser.setFitnessGoal(newFitnessGoal);

            // Update the user in the service
            userService.update(existingUser);
            System.out.println("Profile updated: " + existingUser);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    @Override
    public void createProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** Create Profile ***\n");

        String username = getNonEmptyInput(scanner, "Username: ");
        String password = getNonEmptyInput(scanner, "Password: ");
        String name = getNonEmptyInput(scanner, "Name: ");
        int age = getPositiveIntInput(scanner, "Age: ");
        float weight = getPositiveFloatInput(scanner, "Weight (kg): ");
        float height = getPositiveFloatInput(scanner, "Height (cm): ");
        String fitnessGoal = getValidFitnessGoal(scanner);

        User user = new User(username, password, name, age, weight, height, fitnessGoal);
        new UserProfile().setUser(user);
        System.out.println("Profile created");
    }

    private String getNonEmptyInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }

    private int getPositiveIntInput(Scanner scanner, String prompt) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                if (input > 0) return input;
            }
            System.out.println("Please enter a positive integer.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private float getPositiveFloatInput(Scanner scanner, String prompt) {
        float input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextFloat()) {
                input = scanner.nextFloat();
                scanner.nextLine(); // Clear buffer
                if (input > 0) return input;
            }
            System.out.println("Please enter a positive number.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    private String getValidFitnessGoal(Scanner scanner) {
        String fitnessGoal;
        do {
            System.out.print("Fitness Goal (conditioning, weight_loss, muscle_growth): ");
            fitnessGoal = scanner.nextLine().toLowerCase();
        } while (!fitnessGoal.matches("conditioning|weight_loss|muscle_growth"));
        return fitnessGoal;
    }

    private int getPositiveIntInputOrEmpty(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) {
                return -1;
            }
            try {
                int input = Integer.parseInt(inputLine);
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }
    }

    private float getPositiveFloatInputOrEmpty(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String inputLine = scanner.nextLine().trim();
            if (inputLine.isEmpty()) {
                return -1;
            }
            try {
                float input = Float.parseFloat(inputLine);
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive number.");
            }
        }
    }

    private String getValidFitnessGoalOrEmpty(Scanner scanner, String prompt) {
        String fitnessGoal;
        do {
            System.out.print(prompt);
            fitnessGoal = scanner.nextLine().toLowerCase();
        } while (!fitnessGoal.matches("conditioning|weight_loss|muscle_growth|"));
        return fitnessGoal;
    }

    private int getValidatedUserId(String prompt) {
        int userId;
        // Prompt for user ID with validation
        while (true) {
            System.out.print(prompt);
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
        return userId;
    }
}
