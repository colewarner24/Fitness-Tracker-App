package fitnesstracker.designs.userprofilemanagement;

public interface IProfileManager {

    void createProfile(UserProfile profile);
    UserProfile getProfile(int userId);
    void updateProfile(UserProfile profile);
}
