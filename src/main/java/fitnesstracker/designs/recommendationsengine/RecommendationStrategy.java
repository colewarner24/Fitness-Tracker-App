package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.userprofilemanagement.UserProfile;
import fitnesstracker.model.User;

import java.util.List;

public interface RecommendationStrategy {
    List<String> recommendWorkouts(User user);
}
