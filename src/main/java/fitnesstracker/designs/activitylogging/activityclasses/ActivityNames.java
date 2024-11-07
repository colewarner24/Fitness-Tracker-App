package fitnesstracker.designs.activitylogging.activityclasses;

public enum ActivityNames {
    RUNNING("Running", 1),
    CYCLING("Cycling", 2),
    WEIGHT_LIFTING("Weight Lifting", 3);

    private final String displayName;
    private final int workoutId;

    // Constructor
    ActivityNames(String displayName, int workoutId) {
        this.displayName = displayName;
        this.workoutId = workoutId;
    }

    // Getter for display name
    public String getDisplayName() {
        return displayName;
    }
}