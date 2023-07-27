package com.iwb.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtil {
    private static DataSource dataSource;
    static {
        //以流的方式读取配置文件信息
        InputStream inputStream =
                DruidUtil.class.getClassLoader().
                        getResourceAsStream("db.properties");
        //加载配置文件

        Properties p =new Properties();
        try {
            p.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(p);
        }catch (Exception e)
        {e.printStackTrace();}
    }
    public static DataSource getDataSource()
    {
        return dataSource;
    }

}
