package DBAccess;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Yoke on 2017/8/9.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        Reader reader  =  Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        if (sqlSession==null) {
            throw new NullPointerException("fddfdf");
        }
        return sqlSession;
    }
}
