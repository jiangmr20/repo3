将json取出的区间转化为数组：

```java
String gr1 = gradeRange.replaceAll("\\[", "").replaceAll("\\]", "");
String[] number = gr1.split(",");
//转化为数组的区间
int[][]  range = new int[][]{{Integer.valueOf(number[0]),Integer.valueOf(number[1])},
                    {Integer.valueOf(number[2]),Integer.valueOf(number[3])},
                    {Integer.valueOf(number[4]),Integer.valueOf(number[5])},
                    {Integer.valueOf(number[6]),Integer.valueOf(number[7])}};
```

