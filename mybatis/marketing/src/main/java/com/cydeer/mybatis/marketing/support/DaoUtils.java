package com.cydeer.mybatis.marketing.support;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * @author song.z
 * @date 2022/3/19 12:46 下午
 */
public class DaoUtils {

    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {

        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static <R> R execute(Function<SqlSession, R> function) {
        SqlSession sqlSession = factory.openSession();
        try {
            R result = function.apply(sqlSession);
            sqlSession.commit();
            return result;
        } finally {
            sqlSession.close();
        }
    }

}
