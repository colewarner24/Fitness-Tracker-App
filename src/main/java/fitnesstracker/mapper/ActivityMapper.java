package fitnesstracker.mapper;

import fitnesstracker.model.Activity;

import java.util.List;

public interface ActivityMapper extends BaseMapper<Activity, Integer> {
    List<Activity> findByUserId(int userId);
}
