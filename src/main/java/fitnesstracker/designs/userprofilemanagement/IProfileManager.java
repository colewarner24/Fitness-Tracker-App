package fitnesstracker.designs.userprofilemanagement;

import fitnesstracker.model.User;

public interface IProfileManager {

    User createProfile();
    UserProfile getProfile();
    User updateProfile();
}
