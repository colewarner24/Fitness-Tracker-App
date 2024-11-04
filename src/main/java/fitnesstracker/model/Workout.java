package fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "workout")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"workoutId", "name", "category"})
public class Workout {

    @XmlElement
    @JsonProperty("workoutId")
    private int workoutId;

    @XmlElement
    @JsonProperty("name")
    private String name;

    @XmlElement
    @JsonProperty("category")
    private String category;

    public Workout() {}

    public Workout(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Workout(int workoutId, String name, String category) {
        this.workoutId = workoutId;
        this.name = name;
        this.category = category;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "workoutId=" + workoutId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;
        Workout workout = (Workout) o;
        return workoutId == workout.workoutId && Objects.equals(name, workout.name) && Objects.equals(category, workout.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workoutId, name, category);
    }
}
