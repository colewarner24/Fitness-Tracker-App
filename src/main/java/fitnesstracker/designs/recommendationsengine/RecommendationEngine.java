package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.designs.activitylogging.Activity;
import fitnesstracker.designs.userprofilemanagement.UserProfile;

import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> generateRecommendations(UserProfile profile, List<Activity> activities) {
        return strategy.recommendWorkouts(profile, activities);
    }
}
