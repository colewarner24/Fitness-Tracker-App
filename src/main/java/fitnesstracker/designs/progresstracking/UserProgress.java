package fitnesstracker.designs.progresstracking;

import fitnesstracker.model.Progress;
import fitnesstracker.model.User;
import fitnesstracker.service.ProgressService;
import fitnesstracker.service.UserService;

import java.time.LocalDateTime;

public class UserProgress {
    Progress progress = new Progress();

    public Progress getUserProgress(int id) {
        return new ProgressService().findById(id);
    }

    public void setUserProgress(Progress progress) {
        new ProgressService().create(progress);
    }
}

