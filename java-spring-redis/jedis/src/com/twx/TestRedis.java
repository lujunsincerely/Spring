package com.twx;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;

/**
 * Created by twx on 2017/6/26.
 */
public class TestRedis {
    private Jedis jedis;

    public void connect() {
        jedis = new Jedis("127.0.0.1",6379);
    }

    public void testString() {
        jedis.set("name", "tangwenxing");
        String name = jedis.get("name");
        System.out.println("ley-name:"+name);

        jedis.mset("name", "twx", "age", "25", "gender", "man");
        List<String> vals = jedis.mget("name", "age");
        for (String str : vals) {
            System.out.print(str+" ");
        }
        System.out.println();

        jedis.del("name");
        System.out.println("name-->>"+jedis.get("name"));
    }


    public void testHash() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "ymj");
        map.put("age", "24");
        map.put("qq", "51510381*");
        jedis.hmset("hmap", map);

        System.out.println(jedis.hget("hmap","name"));
        System.out.println(jedis.hkeys("hmap"));
        System.out.println(jedis.hgetAll("hmap"));
        System.out.println(jedis.hvals("hmap"));
        System.out.println(jedis.hlen("hmap"));
        System.out.println(jedis.hsetnx("hmap","qq","51514563"));//field不存在時 才设值
    }

    public void testList() {
        jedis.del("alist");

        jedis.lpush("alist", "redis");//插入到头部
        jedis.lpush("alist", "mongondb");

        System.out.println(jedis.lrange("alist", 0, 5));

        jedis.rpush("alist", "mysql");//插入到尾部
        System.out.println(jedis.lrange("alist", 0, 5));

        System.out.println("长度：" + jedis.llen("alist"));
        System.out.println("获取第N个元素 " + jedis.lindex("alist", 1));
        System.out.println("设值："+jedis.lset("alist",0,"oracle"));

        System.out.println("设值后 " + jedis.lrange("alist", 0, 5));
        System.out.println("删除表头 "+jedis.lpop("alist"));
        System.out.println("删除后 " + jedis.lrange("alist", 0, 5));
    }

    public static void main(String[] args) {
        TestRedis testRedis = new TestRedis();
        testRedis.connect();
        //1 testString
//        testRedis.testString();

        //2 test Hash
//        testRedis.testHash();

        //3 test List
        testRedis.testList();
    }
}
