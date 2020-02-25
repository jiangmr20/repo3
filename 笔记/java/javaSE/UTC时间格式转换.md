```java
public static String changeToUTCTime(String dateStr) throws Exception{
        //本地时间（北京时间），如2016-06-11 23:59:59
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        //utc时间（北京时间是utc时间+8小时，所以此时utc时间应该是 2016-06-11 15:59:59）
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        String res1 = sdf2.format(date);
        String res2 = res1 + "Z";
        return res2;
    }
```

https://blog.csdn.net/Fanbin168/article/details/53313979?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task

https://blog.csdn.net/chulieju9954/article/details/100818919?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task

https://blog.csdn.net/RZ_1107/article/details/60957283

https://blog.csdn.net/java_ying/article/details/90078042