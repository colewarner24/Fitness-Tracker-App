package fitnesstracker.mapper;

import fitnesstracker.model.Progress;

import java.util.List;

public interface ProgressMapper extends BaseMapper<Progress, Integer> {
    Progress findByUserId(int userId);
}
