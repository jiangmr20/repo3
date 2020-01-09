在mysql取出dateTime类型的数据时，用map接收，在java端gson处理后只有年月日没有时分秒

```xml
<select id="selectLoadedRecordList" resultType="map">
        select tlml.id id, tnu.user_name person, tlml.reason advice, tlml.load_time time
        from tb_load_manage_list tlml
        left join tb_new_rel_user_department tnrud on tlml.user_dept_id = tnrud.id
        left join tb_new_user tnu on tnrud.user_id = tnu.user_id
        order by load_time desc
        <if test="pageSize != null">
            limit #{index},#{pageSize}
        </if>
    </select>
```

原因出在，gson的转化：

```java
public class CommonResultUtil {

	private static Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd").create();
```

增加一个新的格式转化gson就好

```java
public class CommonResultUtil {

	private static Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd").create();

	private static Gson dateTimeGson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

```

https://blog.csdn.net/duanlb_001/article/details/70159034

