package com.dfbz.day41;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {
    //创建私有静态数据源成员变量
    private static DataSource ds;

    //在静态代码块中创建连接池
    static {
        //创建属性对象
        Properties info = new Properties();
        try (InputStream in = DataSourceUtil.class.getResourceAsStream("/druid.properties")) {
            //从类路径下加载属性文件，得到输入流对象
            info.load(in);
            //通过工厂类创建一个数据源
            ds = DruidDataSourceFactory.createDataSource(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //得到数据源
    public static DataSource getDataSource() {
        return ds;
    }

    //得到连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
