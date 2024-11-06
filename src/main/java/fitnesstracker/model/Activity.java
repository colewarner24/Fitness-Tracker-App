package fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "activity")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"activityId", "userId", "workoutId", "duration", "intensity", "caloriesBurned", "timestamp"})
public class Activity {

    @XmlElement
    @JsonProperty("activityId")
    private int activityId;

    @XmlElement
    @JsonProperty("userId")
    private int userId;

    @XmlElement
    @JsonProperty("workoutId")
    private int workoutId;

    @XmlElement
    @JsonProperty("duration")
    private int duration;

    @XmlElement
    @JsonProperty("intensity")
    private String intensity;

    @XmlElement
    @JsonProperty("caloriesBurned")
    private float caloriesBurned;

    @XmlElement
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    public Activity() {}

    public Activity(int userId, int workoutId, int duration, String intensity, float caloriesBurned, String timestamp) {
        this.userId = userId;
        this.workoutId = workoutId;
        this.duration = duration;
        this.intensity = intensity;
        this.caloriesBurned = caloriesBurned;
        setTimestampFromStr(timestamp);
    }

    public Activity(int userId, int workoutId, int duration, String intensity, float caloriesBurned, LocalDateTime timestamp) {
        this.userId = userId;
        this.workoutId = workoutId;
        this.duration = duration;
        this.intensity = intensity;
        this.caloriesBurned = caloriesBurned;
        this.timestamp = timestamp;
    }

    public Activity(int activityId, int userId, int workoutId, int duration, String intensity, float caloriesBurned, String timestamp) {
        this.activityId = activityId;
        this.userId = userId;
        this.workoutId = workoutId;
        this.duration = duration;
        this.intensity = intensity;
        this.caloriesBurned = caloriesBurned;
        setTimestampFromStr(timestamp);
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public float getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(float caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestampFromStr(String strTimestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.parse(strTimestamp, formatter);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", userId=" + userId +
                ", workoutId=" + workoutId +
                ", duration=" + duration +
                ", intensity='" + intensity + '\'' +
                ", caloriesBurned=" + caloriesBurned +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return activityId == activity.activityId && userId == activity.userId && workoutId == activity.workoutId &&
                duration == activity.duration && Float.compare(activity.caloriesBurned, caloriesBurned) == 0 &&
                Objects.equals(intensity, activity.intensity) && Objects.equals(timestamp, activity.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activityId, userId, workoutId, duration, intensity, caloriesBurned, timestamp);
    }
}
