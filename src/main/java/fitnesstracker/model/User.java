package fitnesstracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({"userId", "username", "password", "name", "age", "weight", "height", "fitnessGoal", "createdAt"})
public class User {

    @XmlElement
    @JsonProperty("userId")
    private int userId;

    @XmlElement
    @JsonProperty("username")
    private String username;

    @XmlElement
    @JsonProperty("password")
    private String password;

    @XmlElement
    @JsonProperty("name")
    private String name;

    @XmlElement
    @JsonProperty("age")
    private int age;

    @XmlElement
    @JsonProperty("weight")
    private float weight;

    @XmlElement
    @JsonProperty("height")
    private float height;

    @XmlElement
    @JsonProperty("fitnessGoal")
    private String fitnessGoal; // conditioning, weight_loss, muscle_growth

    @XmlElement
    @JsonProperty("createdAt")
    private String createdAt;

    public User() {}

    public User(int userId, String username, String password, String name, int age, float weight, float height, String fitnessGoal, String createdAt) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.fitnessGoal = fitnessGoal;
        this.createdAt = createdAt;
    }

    public User(String username, String password, String name, int age, float weight, float height, String fitnessGoal) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.fitnessGoal = fitnessGoal;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", fitnessGoal='" + fitnessGoal + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                age == user.age &&
                Float.compare(user.weight, weight) == 0 &&
                Float.compare(user.height, height) == 0 &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(fitnessGoal, user.fitnessGoal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, password, name, age, weight, height, fitnessGoal);
    }
}
