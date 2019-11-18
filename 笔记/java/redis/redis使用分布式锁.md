https://www.cnblogs.com/cmyxn/p/9047848.html

```java
 @Retryable(value = {Exception.class}, backoff = @Backoff(delay = 5000L, multiplier = 1))
    void processMessage() throws Exception {
        //加分布式锁，保证时序性
        boolean lock = redisTemplate.opsForValue().setIfAbsent(KEY, LOCK);
        try {
            if (lock) {
                List<String> messages = new ArrayList<>();
                String responseBody = "";
                try {
                    messages = jedis.brpop(0, RequestNoteService.MESSAGE_KEY);
                    if (messages != null && messages.size() != 0) {
                        responseBody = sendPostRequest(messages.get(1));
                    }
                    Map<String, Object> resultMap = jasksonMapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
                    });
                    if (!Integer.valueOf(String.valueOf(resultMap.get("resultCode"))).equals(0)) {
                        if (messages != null && messages.size() != 0) {
                            //返回错误再push回去
                            jedis.rpush(RequestNoteService.MESSAGE_KEY, messages.get(1));
                        }
                        logger.error("返回值错误");
                        throw new Exception();
                    } else {
                        processMessage();
                    }
                } catch (Exception e) {
                    if (messages != null && messages.size() != 0) {
                        //返回错误再push回去
                        jedis.rpush(RequestNoteService.MESSAGE_KEY, messages.get(1));
                    }
                    logger.error("发送失败", e);
                    e.printStackTrace();
                    throw e;
                }
            }
        } finally {
            if (lock) {
                redisTemplate.delete(KEY);
            }
        }
    }
```

