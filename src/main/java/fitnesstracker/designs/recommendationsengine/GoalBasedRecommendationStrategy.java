package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.model.User;
import java.util.ArrayList;
import java.util.List;

public class GoalBasedRecommendationStrategy implements RecommendationStrategy {

    @Override
    public List<String> recommendWorkouts(User user) {
        List<String> recommendedWorkouts = new ArrayList<>();

        // Use the user's fitness goal to recommend workouts
        switch (user.getFitnessGoal().toLowerCase()) {
            case "conditioning":
                recommendedWorkouts.add("running");
                recommendedWorkouts.add("cycling");
                recommendedWorkouts.add("swimming");
                break;
            case "weight_loss":
                recommendedWorkouts.add("HIIT workout");
                recommendedWorkouts.add("jump rope");
                recommendedWorkouts.add("treadmill running");
                break;
            case "muscle_growth":
                recommendedWorkouts.add("weight lifting");
                recommendedWorkouts.add("bodyweight exercises");
                recommendedWorkouts.add("resistance training");
                break;
            default:
                recommendedWorkouts.add("general stretching exercises");
                recommendedWorkouts.add("yoga");
                break;
        }

        return recommendedWorkouts;
    }
}
