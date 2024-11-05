package fitnesstracker.designs.userprofilemanagement;

import fitnesstracker.model.User;
import fitnesstracker.service.UserService;

import java.util.Scanner;

public class UserProfileManager implements IProfileManager {
    private final UserService userService = new UserService();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void createProfile(UserProfile profile) {
        System.out.println("Enter user details:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Weight (kg): ");
        float weight = Float.parseFloat(scanner.nextLine());

        System.out.print("Height (cm): ");
        float height = Float.parseFloat(scanner.nextLine());

        System.out.print("Fitness Goal (conditioning, weight_loss, muscle_growth): ");
        String fitnessGoal = scanner.nextLine();

        User user = new User(username, password, name, age, weight, height, fitnessGoal);
        profile.setUser(user);

        System.out.println("Profile created: " + user);
    }

    @Override
    public UserProfile getProfile(int userId) {
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
    public void updateProfile(UserProfile profile) {
        System.out.print("Enter user ID to update: ");
        int userId = Integer.parseInt(scanner.nextLine());

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

            System.out.print("New Age (leave blank to keep unchanged): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) existingUser.setAge(Integer.parseInt(ageInput));

            System.out.print("New Weight (kg, leave blank to keep unchanged): ");
            String weightInput = scanner.nextLine();
            if (!weightInput.isEmpty()) existingUser.setWeight(Float.parseFloat(weightInput));

            System.out.print("New Height (cm, leave blank to keep unchanged): ");
            String heightInput = scanner.nextLine();
            if (!heightInput.isEmpty()) existingUser.setHeight(Float.parseFloat(heightInput));

            System.out.print("New Fitness Goal (leave blank to keep unchanged): ");
            String newFitnessGoal = scanner.nextLine();
            if (!newFitnessGoal.isEmpty()) existingUser.setFitnessGoal(newFitnessGoal);

            // Update the user in the service
            userService.update(existingUser);
            System.out.println("Profile updated: " + existingUser);
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }
}
