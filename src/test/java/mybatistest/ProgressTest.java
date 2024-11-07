package mybatistest;

import fitnesstracker.model.User;
import fitnesstracker.model.Progress;
import fitnesstracker.service.UserService;
import fitnesstracker.service.ProgressService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgressTest {

    private User user;
    private Progress progress;
    private UserService userService;
    private ProgressService progressService;

    @Before
    public void setUp() {
        userService = new UserService();
        progressService = new ProgressService();

        // Creating a user record to link with the progress record
        user = new User("testuser", "password", "Test User", 30, 70.0f, 175.0f, "weight_loss");
        userService.create(user);

        // Initialize progress data linked to the created user
        progress = new Progress(user.getUserId(), 500, 10.5f, 3, 4, 15.0f, 68.0f,"2024-11-04 10:00:00");
        progressService.create(progress);
    }

    @Test
    public void testCreateProgress() {
        Progress dbProgress = progressService.findById(progress.getProgressId());
        assert progress.equals(dbProgress);
    }

    @Test
    public void testUpdateProgress() {
        progress.setTotalCaloriesBurned(700.0f);
        progress.setTotalDistance(15.0f);
        progress.setWorkoutsCompleted(5);
        progressService.update(progress);

        Progress dbProgress = progressService.findById(progress.getProgressId());
        assert progress.equals(dbProgress);
    }

    @Test
    public void testFindByUserId() {
        Progress dbProgress = progressService.findByUserId(user.getUserId());
        assert progress.equals(dbProgress);
    }

    @Test
    public void testDeleteProgress() {
        progressService.delete(progress.getProgressId());
        Progress dbProgress = progressService.findById(progress.getProgressId());
        assert dbProgress == null;
    }

    @After
    public void tearDown() {
        progressService.delete(progress.getProgressId());
        userService.delete(user.getUserId());
    }
}
