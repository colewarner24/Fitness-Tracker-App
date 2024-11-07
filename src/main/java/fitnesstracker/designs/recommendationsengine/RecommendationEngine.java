package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.model.User;
import java.util.List;

public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public void setRecommendationStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<String> generateRecommendations(User user) {
        return strategy.recommendWorkouts(user);
    }
}
