package fitnesstracker.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import fitnesstracker.model.Activity;
import fitnesstracker.util.MyBatisUtil;

public class ActivityMapper implements BaseMapper<Activity, Integer> {
    public static final SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();

    @Override
    public void create(Activity activity) {
        try (SqlSession session = factory.openSession()) {
            session.insert("fitnesstracker.mapper.ActivityMapper.create", activity);
            session.commit();
        }
    }

    @Override
    public Activity findById(Integer id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("fitnesstracker.mapper.ActivityMapper.findById", id);
        }
    }

    @Override
    public List<Activity> getAll() {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("fitnesstracker.mapper.ActivityMapper.getAll");
        }
    }

    @Override
    public void update(Activity activity) {
        try (SqlSession session = factory.openSession()) {
            session.update("fitnesstracker.mapper.ActivityMapper.update", activity);
            session.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("fitnesstracker.mapper.ActivityMapper.delete", id);
            session.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (SqlSession session = factory.openSession()) {
            session.delete("fitnesstracker.mapper.ActivityMapper.deleteAll");
            session.commit();
        }
    }
}
