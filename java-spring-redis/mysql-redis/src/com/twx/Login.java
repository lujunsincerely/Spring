package com.twx;

import com.twx.db.Mysql;
import redis.clients.jedis.Jedis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by twx on 2017/6/26.
 */
public class Login {
    private Connection connection;
    private  Jedis jedis;

    public Login() {
        this.connection = Mysql.connet();
        this.jedis = new Jedis("127.0.0.1",6379);
    }


    //模拟登入
    public void mockLogin() throws SQLException {
        String id = "2";
        String sql = "select * from user t  where t.id=" + id;

        if (jedis.exists("user_"+id)) {
            System.out.println("从redis中获取数据");
            Map<String, String> map = jedis.hgetAll("user_" + id);
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                System.out.println(next.getKey()+ "-->>"+next.getValue());
            }
        } else {
            ResultSet resultSet = connection.createStatement().executeQuery(sql);
            if (resultSet.next()) {  //这里应该用while的
                System.out.println("从mysql中获取数据...");
                Map<String, String> map = new HashMap<>();
                map.put("name", resultSet.getString("name"));
                map.put("age", resultSet.getString("age"));
                map.put("qq", resultSet.getString("qq"));
                jedis.hmset("user_"+id,map);

                jedis.expire("user_"+id, 60);//60秒过期
            }else{
                System.out.println("数据库中不存在");
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        Login login = new Login();

        login.mockLogin();
    }
}
