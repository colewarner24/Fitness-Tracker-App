package fitnesstracker.designs.userprofilemanagement;

import fitnesstracker.model.User;
import fitnesstracker.service.UserService;

public class UserProfile {
    User user = new User();

    public User getUser(int id) {
        return new UserService().findById(id);
    }

    public void setUser(User user) {
        new UserService().create(user);
    }
}