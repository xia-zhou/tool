//package org.example.area;
//
//import org.apache.ibatis.mapping.Environment;
//import org.apache.ibatis.session.Configuration;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.transaction.TransactionFactory;
//import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
//import org.example.mapper.AlipayAreaMapper;
//import org.junit.jupiter.api.Test;
//
//import javax.sql.DataSource;
//
//
///**
// * @author song.z
// * @date 2023/5/26 14:,19
// */
//public class AreaTest {
//    @Test
//    public void testFind() {
//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(AlipayAreaMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//    }
//
//}
