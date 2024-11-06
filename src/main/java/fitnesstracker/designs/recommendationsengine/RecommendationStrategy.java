package fitnesstracker.designs.recommendationsengine;

import fitnesstracker.designs.activitylogging.activityclasses.ActivityBase;
import fitnesstracker.designs.userprofilemanagement.UserProfile;

import java.util.List;

public interface RecommendationStrategy {
    List<String> recommendWorkouts(UserProfile profile, List<ActivityBase> activities);
}
