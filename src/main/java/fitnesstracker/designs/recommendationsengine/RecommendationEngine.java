package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.userprofilemanagement.UserProfile;

import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> generateRecommendations(UserProfile profile, List<ActivityBase> activities) {
        return strategy.recommendWorkouts(profile, activities);
    }
}
