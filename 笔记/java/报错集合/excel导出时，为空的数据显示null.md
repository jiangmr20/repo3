![1578541787980](E:\学习\笔记\picRepo\1578541787980.png)

我的解决方法：将为空的字段填入""

```java
//把"null"的数值转化为""
            for (Map.Entry<String, Object> entry : tmp.entrySet()){
                if (entry.getValue() == null || "null".equals(entry.getValue().toString())) {
//                    entry.setValue("");
                    tmp.replace(entry.getKey(), "");
                }
            }
```

debug代码时，这里走的是左边，即entry.getValue == null

但是后面的tmp查却是"null"

```java
String endTime = String.valueOf(tmp.get("endDate"));
            if (!StringUtil.empty(endTime) && !"null".equals(endTime)) {
                String currentTime = DateUtils.getNowAsString();
                int days = DateUtils.distanceForTime(currentTime, endTime, 1);
                if (days <= 30) {
                    tmp.put("isWarn", 1);
                } else {
                    tmp.put("isWarn", 0);
//                if(!StringUtil.empty(status) && ConstantCode.CoopProdStatus.WARNING == Integer.parseInt(status)){
//                    iter.remove();
//                }
                }
            }
```

很奇怪

