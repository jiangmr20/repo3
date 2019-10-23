https://bbs.csdn.net/topics/330074104

比较简洁的一个方法：

```java
Set<String> data = new HashSet<String>();
String[] str = data.toArray(new String[data.size()]);
```

