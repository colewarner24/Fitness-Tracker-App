package fitnesstracker.service;

import fitnesstracker.mapper.ActivityMapper;
import fitnesstracker.mapper.ProgressMapper;
import fitnesstracker.model.Activity;
import fitnesstracker.model.Progress;
import fitnesstracker.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Objects;

public class ProgressService extends BaseService<Progress, Integer, ProgressMapper> {

    @Override
    protected Class<ProgressMapper> getMapperClass() {
        return ProgressMapper.class;
    }

    public Progress findByUserId(int userId) {
        try (SqlSession session = Objects.requireNonNull(MyBatisUtil.getSqlSessionFactory()).openSession(true)) {
            ProgressMapper mapper = session.getMapper(getMapperClass());
            return mapper.findByUserId(userId);
        }
    }

}