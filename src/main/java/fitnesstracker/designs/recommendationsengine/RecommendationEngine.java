package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.model.User;
import fitnesstracker.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;
    private UserService userService;

    // Constructor
    public RecommendationEngine() {
        this.userService = new UserService();  // Initialize UserService here
    }

    // Set recommendation strategy
    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    // Generate recommendations based on user ID
    public List<String> generateRecommendations(int userId) {
        // Fetch the user by ID
        User user = userService.findById(userId);

        if (user == null) {
            System.err.println("Error: User with ID " + userId + " not found.");
            return new ArrayList<>();  // Return an empty list if user not found
        }

        // Generate recommendations based on user details
        return strategy.recommendWorkouts(user);
    }
}
