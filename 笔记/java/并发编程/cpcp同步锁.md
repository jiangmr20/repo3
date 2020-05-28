 https://blog.csdn.net/LHacker/category_1537401.html 

```java
@Autowired
    @Qualifier("stringRedisTemplate")
    private RedisTemplate<String, String> lockTemplate;

@Autowired
    private RedisTemplate<String, LinkedList<String>> redisTemplate;

//分布式锁
    public boolean tryAcquire(String processId){
        logger.info("获取分布式锁---------");
        String requestId = UUID.randomUUID().toString();
        int pos = 0;
        // 自旋获取锁
        while(pos < MAX_WAIT_TIMES) {
            if (lockTemplate.opsForValue().setIfAbsent(getLockKey(processId), requestId)) {
                lockTemplate.expire(getLockKey(processId), lockTimeOut, TimeUnit.MILLISECONDS);
                return true;
            }
            try {
                Thread.sleep(lockTimeOut);
            }catch (Exception e){
                logger.info("自旋等待异常：" + e.getMessage());
            }
        }
        return false;
    }

public void unlock(String processId){
        lockTemplate.delete( getLockKey(processId));
    }

private void pushInCache(String processId, String msg, int status){

        if(StringUtil.empty(processId)){
            return ;
        }
        if (tryAcquire(processId)) {
            //获取锁成功-----------
            logger.info("获取锁成功----------");
            LinkedList<String> que = redisTemplate.opsForValue().get(getKey(processId));
            if (que == null) {
                que = new LinkedList<>();
                que.addLast(msg);
            } else {
                if (status == SUBMIT) {
                    que.set(0, msg);
                } else {
                    que.addLast(msg);
                }
            }
            redisTemplate.opsForValue().set(getKey(processId), que, dataTimeOut, TimeUnit.DAYS);
            logger.info("缓存成功：" + msg);
            unlock(processId);
        }

    }




```

