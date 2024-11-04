package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.designs.activitylogging.Activity;
import fitnesstracker.designs.userprofilemanagement.UserProfile;

import java.util.List;

public interface RecommendationStrategy {
    List<String> recommendWorkouts(UserProfile profile, List<Activity> activities);
}
