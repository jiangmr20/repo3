https://blog.csdn.net/zbdxcyg/article/details/78519773

https://blog.csdn.net/fmwind/article/details/77744294

一个图映射出标签的例子：

https://blog.csdn.net/qq_40135955/article/details/91378307

 ![img](E:\学习\笔记\picRepo\1459991311156048784.jpg) 

映射出的标签为：

```xml
<startEvent id="startevent1" name="Start"></startEvent>

<endEvent id="endevent1" name="End"></endEvent>

<userTask id="usertask1" name="HelloWorld" activiti:assignee="java1234_小锋"></userTask>

<sequenceFlow id="flow1" sourceRef="startevent1" targetRef="usertask1"></sequenceFlow>

<sequenceFlow id="flow2" sourceRef="usertask1" targetRef="endevent1"></sequenceFlow>
```



第二个例子：

https://www.cnblogs.com/teacher11/p/9101717.html