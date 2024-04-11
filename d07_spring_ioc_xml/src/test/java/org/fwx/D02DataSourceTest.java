package org.fwx;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @ClassName D02DataSourceTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 19:34
 * @Version 1.0
 */
public class D02DataSourceTest {
    @Test
    public void dataSourceTest() throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
    }
}
