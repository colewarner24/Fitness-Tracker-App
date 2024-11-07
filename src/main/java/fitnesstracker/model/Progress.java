package fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@XmlRootElement(name = "progress")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"progressId", "userId", "totalCaloriesBurned", "totalDistance", "workoutsCompleted", "weeklyWorkoutGoal", "weeklyDistanceGoal", "weightGoal", "lastUpdated"})
public class Progress {

    @XmlElement
    @JsonProperty("progressId")
    private int progressId;

    @XmlElement
    @JsonProperty("userId")
    private int userId;

    @XmlElement
    @JsonProperty("totalCaloriesBurned")
    private float totalCaloriesBurned;

    @XmlElement
    @JsonProperty("totalDistance")
    private float totalDistance;

    @XmlElement
    @JsonProperty("workoutsCompleted")
    private int workoutsCompleted;

    @XmlElement
    @JsonProperty("weeklyWorkoutGoal")
    private int weeklyWorkoutGoal;

    @XmlElement
    @JsonProperty("weeklyDistanceGoal")
    private float weeklyDistanceGoal;

    @XmlElement
    @JsonProperty("weightGoal")
    private float weightGoal;

    @XmlElement
    @JsonProperty("lastUpdated")
    private Timestamp lastUpdated;

    public Progress() {}

    public Progress(int userId, float totalCaloriesBurned, float totalDistance, int workoutsCompleted, int weeklyWorkoutGoal, float weeklyDistanceGoal, float weightGoal, Timestamp lastUpdated) {
        this.userId = userId;
        this.totalCaloriesBurned = totalCaloriesBurned;
        this.totalDistance = totalDistance;
        this.workoutsCompleted = workoutsCompleted;
        this.weeklyWorkoutGoal = weeklyWorkoutGoal;
        this.weeklyDistanceGoal = weeklyDistanceGoal;
        this.weightGoal = weightGoal;
        this.lastUpdated = lastUpdated;
    }

    public Progress(int progressId, int userId, float totalCaloriesBurned, float totalDistance, int workoutsCompleted, int weeklyWorkoutGoal, float weeklyDistanceGoal, float weightGoal, Timestamp lastUpdated) {
        this.progressId = progressId;
        this.userId = userId;
        this.totalCaloriesBurned = totalCaloriesBurned;
        this.totalDistance = totalDistance;
        this.workoutsCompleted = workoutsCompleted;
        this.weeklyWorkoutGoal = weeklyWorkoutGoal;
        this.weeklyDistanceGoal = weeklyDistanceGoal;
        this.weightGoal = weightGoal;
        this.lastUpdated = lastUpdated;
    }

    public int getProgressId() {
        return progressId;
    }

    public void setProgressId(int progressId) {
        this.progressId = progressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(float totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }

    public void setWorkoutsCompleted(int workoutsCompleted) {
        this.workoutsCompleted = workoutsCompleted;
    }

    public int getWeeklyWorkoutGoal() {
        return weeklyWorkoutGoal;
    }

    public void setWeeklyWorkoutGoal(int weeklyWorkoutGoal) {
        this.weeklyWorkoutGoal = weeklyWorkoutGoal;
    }

    public float getWeeklyDistanceGoal() {
        return weeklyDistanceGoal;
    }

    public void setWeeklyDistanceGoal(float weeklyDistanceGoal) {
        this.weeklyDistanceGoal = weeklyDistanceGoal;
    }

    public float getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(float weightGoal) {
        this.weightGoal = weightGoal;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "progressId=" + progressId +
                ", userId=" + userId +
                ", totalCaloriesBurned=" + totalCaloriesBurned +
                ", totalDistance=" + totalDistance +
                ", workoutsCompleted=" + workoutsCompleted +
                ", weeklyWorkoutGoal=" + weeklyWorkoutGoal +
                ", weeklyDistanceGoal=" + weeklyDistanceGoal +
                ", weightGoal=" + weightGoal +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progress)) return false;
        Progress progress = (Progress) o;
        return progressId == progress.progressId && userId == progress.userId &&
                Float.compare(progress.totalCaloriesBurned, totalCaloriesBurned) == 0 &&
                Float.compare(progress.totalDistance, totalDistance) == 0 && workoutsCompleted == progress.workoutsCompleted &&
                weeklyWorkoutGoal == progress.weeklyWorkoutGoal && Float.compare(progress.weeklyDistanceGoal, weeklyDistanceGoal) == 0 &&
                Float.compare(progress.weightGoal, weightGoal) == 0 && Objects.equals(lastUpdated, progress.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(progressId, userId, totalCaloriesBurned, totalDistance, workoutsCompleted, weeklyWorkoutGoal, weeklyDistanceGoal, weightGoal, lastUpdated);
    }
}
