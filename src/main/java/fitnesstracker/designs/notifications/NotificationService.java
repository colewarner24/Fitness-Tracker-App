package fitnesstracker.designs.notifications;

import fitnesstracker.model.User;
import fitnesstracker.model.Progress;
import fitnesstracker.service.ProgressService;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class NotificationService {


    public void milestoneCheck(User user, Progress progress) {
        if (progress.getWorkoutsCompleted() >= progress.getWeeklyWorkoutGoal()) {
            System.out.println("Congratulations! You've achieved your weekly workout goal!");
        }
        else{
            System.out.println("You are " + (progress.getWeeklyWorkoutGoal() - progress.getWorkoutsCompleted()) + "away from your workout goal!");
        }
    }

    public void distanceCheck(User user, Progress progress) {
        if (progress.getTotalDistance() >= progress.getWeeklyDistanceGoal()) {
            System.out.println("Congratulations! You've achieved your weekly distance goal!");
        }
        else{
            System.out.println("You are " + (progress.getWeeklyDistanceGoal() - progress.getTotalDistance()) + "away from your distance goal!");
        }
    }

    public void dailyNotification(User user) {
        ProgressService progressService = new ProgressService();
        Progress progress = progressService.findByUserId(user.getUserId());
        System.out.println("Goal Summary for the day ");
        if (progress.getWeeklyWorkoutGoal() > 0){
            milestoneCheck(user, progress);
        }
        if (progress.getWeeklyDistanceGoal() > 0){
            distanceCheck(user, progress);
        }
    }
}

