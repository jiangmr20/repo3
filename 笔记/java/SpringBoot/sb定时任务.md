定时任务注解Schedule的参数使用：

https://www.jianshu.com/p/1defb0f22ed1

创建定时任务：https://blog.csdn.net/xilichong/article/details/79888885

例子：

```java
@Component
public class FlushRedisTask {

    private static Logger logger = LoggerFactory.getLogger(FlushRedisTask.class);

    @Autowired
    private AdminCommonService commonService;

    @Scheduled(cron = "0 0 3 * * ?")
    public void flushRedis() {
        try {
            logger.info("定时刷新用户权限缓存任务启动");
            commonService.manualFlushMenuRedis();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("定时刷新用户权限缓存任务出错", e);
        } finally {
            logger.info("定时刷新用户权限缓存任务结束");
        }
    }

}

```

