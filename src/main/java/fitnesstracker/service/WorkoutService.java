package fitnesstracker.service;

import fitnesstracker.mapper.WorkoutMapper;
import fitnesstracker.model.Workout;

public class WorkoutService extends BaseService<Workout, Integer, WorkoutMapper> {

    @Override
    protected Class<WorkoutMapper> getMapperClass() {
        return WorkoutMapper.class;
    }
}
