package fitnesstracker.service;

import fitnesstracker.mapper.ProgressMapper;
import fitnesstracker.model.Progress;

public class ProgressService extends BaseService<Progress, Integer, ProgressMapper> {

    @Override
    protected Class<ProgressMapper> getMapperClass() {
        return ProgressMapper.class;
    }
}