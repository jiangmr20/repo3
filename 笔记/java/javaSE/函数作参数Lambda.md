Lambda表达式：https://www.runoob.com/java/java8-new-features.html

例子：

```java
List<ProcessEntity> processEntityList = processCommonDaoMapper.listProcess(FlowCode.projectCollectCode);
processInstanceList.removeIf(processInstance -> {
            Map<String, Object> variables = processInstance.getProcessVariables();
            if (!StringUtil.empty(keyWord)) {
                if (!String.valueOf(variables.get("productName")).contains(keyWord)) {
                    return true;
                }
            }
            if (!StringUtil.empty(circleId)) {
                if (!String.valueOf(variables.get("circleId")).equals(circleId)) {
                    return true;
                }
            }
            if (!StringUtil.empty(year)) {
                if (!String.valueOf(variables.get("year")).equals(year)) {
                    return true;
                }
            }
            return false;
        });
```

List.removeIf()底层：

```java
 default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        final Iterator<E> each = iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }
```

Predicate<T>接口类：

```
/**
 * Represents a predicate (boolean-valued function) of one argument.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #test(Object)}.
 *
 * @param <T> the type of the input to the predicate
 *
 * @since 1.8
 */
 ...在java1.8底层
```

