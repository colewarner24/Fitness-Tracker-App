package fitnesstracker.service;

import fitnesstracker.mapper.ActivityMapper;
import fitnesstracker.model.Activity;
import fitnesstracker.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;

public class ActivityService extends BaseService<Activity, Integer, ActivityMapper> {

    @Override
    protected Class<ActivityMapper> getMapperClass() {
        return ActivityMapper.class;
    }

    public List<Activity> findByUserId(int userId) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            ActivityMapper mapper = session.getMapper(getMapperClass());
            return mapper.findByUserId(userId);
        }
    }
}

