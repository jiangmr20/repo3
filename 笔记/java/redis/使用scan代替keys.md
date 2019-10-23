使用keys时，要用StringRedisTemplate



https://blog.csdn.net/qq_27721169/article/details/89178793

https://blog.csdn.net/weixin_33991727/article/details/85981035

使用keys进行模糊搜索时，redis容易出现严重的性能降低，原因：https://blog.csdn.net/daodan988/article/details/51822287



自用的scan代码：

```java
/**
     * 使用scan模糊搜索key的值
     * 性能很低！！！！！！！！！仔细看看为什么
     *
     * @param WildParam
     * @return
     */
    public Set getKeysByWildParam(String WildParam) {
        //不用keys，性能低，加锁多
       // Set valueList = stringRedisTemplateTwo.keys("*" + param + "*");
        Set keys = new HashSet<>();
        //使用scan进行模糊搜索keys
        RedisConnection redisConnection = redisTemplateTwo.getConnectionFactory().getConnection();
        Cursor<byte[]> c = redisConnection.scan(new ScanOptions.ScanOptionsBuilder()
                .match("*" + WildParam + "*").build());
        //将scan扫描到的key一个一个加进set里
        while (c.hasNext()) {
            keys.add(new String(c.next()));
        }

        return keys;
    }
```

