package fitnesstracker.service;

import fitnesstracker.mapper.ActivityMapper;
import fitnesstracker.model.Activity;

public class ActivityService extends BaseService<Activity, Integer, ActivityMapper> {

    @Override
    protected Class<ActivityMapper> getMapperClass() {
        return ActivityMapper.class;
    }
}

