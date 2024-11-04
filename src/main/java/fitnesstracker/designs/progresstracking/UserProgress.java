package fitnesstracker.designs.progresstracking;

import java.time.LocalDateTime;

public class UserProgress {
    private int userId;
    private int totalCalories;
    private double totalDistance;
    private int workoutsCompleted;
    private LocalDateTime lastUpdated;

    // Constructor
    public UserProgress(int userId, int totalCalories, double totalDistance, int workoutsCompleted, LocalDateTime lastUpdated) {
        this.userId = userId;
        this.totalCalories = totalCalories;
        this.totalDistance = totalDistance;
        this.workoutsCompleted = workoutsCompleted;
        this.lastUpdated = lastUpdated;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public int getWorkoutsCompleted() {
        return workoutsCompleted;
    }

    public void setWorkoutsCompleted(int workoutsCompleted) {
        this.workoutsCompleted = workoutsCompleted;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    // Method to update progress
    public void updateProgress(int additionalCalories, double additionalDistance, int additionalWorkouts) {
        this.totalCalories += additionalCalories;
        this.totalDistance += additionalDistance;
        this.workoutsCompleted += additionalWorkouts;
        this.lastUpdated = LocalDateTime.now();
    }
}

