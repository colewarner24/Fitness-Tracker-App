package fitnesstracker.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import fitnesstracker.model.Progress;
import fitnesstracker.util.MyBatisUtil;

public class ProgressMapper implements BaseMapper<Progress, Integer> {
    public static final SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();

    @Override
    public void create(Progress progress) {
        try (SqlSession session = factory.openSession()) {
            session.insert("fitnesstracker.mapper.ProgressMapper.create", progress);
            session.commit();
        }
    }

    @Override
    public Progress findById(Integer id) {
        try (SqlSession session = factory.openSession()) {
            return session.selectOne("fitnesstracker.mapper.ProgressMapper.findById", id);
        }
    }

    @Override
    public List<Progress> getAll() {
        try (SqlSession session = factory.openSession()) {
            return session.selectList("fitnesstracker.mapper.ProgressMapper.getAll");
        }
    }

    @Override
    public void update(Progress progress) {
        try (SqlSession session = factory.openSession()) {
            session.update("fitnesstracker.mapper.ProgressMapper.update", progress);
            session.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = factory.openSession()) {
            session.delete("fitnesstracker.mapper.ProgressMapper.delete", id);
            session.commit();
        }
    }

    @Override
    public void deleteAll() {
        try (SqlSession session = factory.openSession()) {
            session.delete("fitnesstracker.mapper.ProgressMapper.deleteAll");
            session.commit();
        }
    }
}
