package fitnesstracker.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.logging.Logger;

public class MyBatisUtil {

    static Logger logger = Logger.getLogger(MyBatisUtil.class.getName());

    private MyBatisUtil() {}

    public static SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            return null;
        }
    }

}
