redis配置的几种方法：

第一种：使用yml文件，放在resource文件夹下

```yml
  redis-one:
    port: 9955
    host: localhost
    timeout: 10000
    database: 8
    password: 123456
    jedis:      
      pool:        
        max-active: 30        
        max-idle: 8        
        min-idle: 3        
        max-wait: 4000
```

然后在服务类使用getBean，创建redis使用工具类：

```java
@Configuration
public class RedisOneConfig {

    public RedisConnectionFactory getRedisConnectionFactory(String hostName,
                                                            String password, int port, int maxActive, int maxIdle, int minIdle,
                                                            long maxWait, int database) { // 是负责建立Factory的连接工厂类
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName(hostName);
        jedisFactory.setPort(port);
        jedisFactory.setPassword(password);
        jedisFactory.setDatabase(database);
        JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        jedisFactory.setPoolConfig(poolConfig);
        jedisFactory.afterPropertiesSet(); // 初始化连接池配置
        return jedisFactory;
    }

    @Bean(name = "redisOne")
    public StringRedisTemplate getRedisTemplate(
            @Value("${spring.redis.host}") String hostName,
            @Value("${spring.redis.password}") String password,
            @Value("${spring.redis.port}") int port,
            @Value("${spring.redis.database}") int database,
            @Value("${spring.redis.jedis.pool.max-active}") int maxActive,
            @Value("${spring.redis.jedis.pool.max-idle}") int maxIdle,
            @Value("${spring.redis.jedis.pool.min-idle}") int minIdle,
            @Value("${spring.redis.jedis.pool.max-wait}") long maxWait) {

        RedisConnectionFactory factory = this.getRedisConnectionFactory(
                hostName, password, port, maxActive, maxIdle, minIdle, maxWait,
                database); // 建立Redis的连接
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer()); // key的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer()); // value的序列化类型
        return redisTemplate;
    }
}
```

service里使用：

```java
	@Resource(name = "redisOne")
    private RedisTemplate<String, Object> redisTemplateTwo;

    @Resource(name = "redisOne")
    private StringRedisTemplate stringRedisTemplateTwo;
```

第二种：使用properties文件，放在resource文件夹下

```properties
redis.host=localhost
redis.port=9955
redis.password=123456
redis.timeout=5000
redis.maxTotal=30
redis.minIdle=5
redis.maxIdle=10
redis.maxWaitMillis=30000
redis.database=8
redis.usePool=true
```

bean配置：

```xml
<bean id="redisTemplate"
              class="org.springframework.data.redis.core.RedisTemplate">
            <property name="connectionFactory" ref="jedisConnFactory" />

            <property name="keySerializer">
                <bean class="org.springframework.data.redis.serializer.StringRedisSerializer"></bean>
            </property>

            <property name="valueSerializer">
                <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"></bean>
            </property>

            <property name="hashKeySerializer">
                <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"></bean>
            </property>

            <property name="hashValueSerializer">
                <bean class="org.springframework.data.redis.serializer.JdkSerializationRedisSerializer"></bean>
            </property>
        </bean>
```

service使用：

1：

```java
RedisTemplate redisTemplate = (RedisTemplate)context.getBean("redisTemplate");
```

2：

```java
	@Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;
```

