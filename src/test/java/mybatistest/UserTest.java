package mybatistest;


import fitnesstracker.model.User;
import fitnesstracker.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user1;
    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService();
        user1 = new User("user1", "password", "John Doe", 25, 130.5f, 180.0f, "muscle_growth");
        userService.create(user1);
    }

    @Test
    public void testCreateUser() {
        User db_user = userService.findById(user1.getUserId());
        assert user1.equals(db_user);
    }

    @Test
    public void testUpdateUser() {
        User userUpdate = new User(user1.getUserId(), user1.getUsername(), "new_password", user1.getName(), user1.getAge(), user1.getWeight(), user1.getHeight(), user1.getFitnessGoal(), user1.getCreatedAt());
        userService.update(userUpdate);
        User db_user = userService.findById(user1.getUserId());
        assert userUpdate.equals(db_user);
    }

    @Test
    public void testDeleteUser() {
        userService.delete(user1.getUserId());
        User db_user = userService.findById(user1.getUserId());
        assert db_user == null;
    }

    @After
    public void tearDown() {
        userService.delete(user1.getUserId());
    }
}
