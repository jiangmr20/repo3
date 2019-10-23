## 1.笛卡尔积(Cartesian product)

顾名思义, 这个概念得名于笛卡儿. 在数学中，两个集合 X 和 Y 的笛卡儿积（Cartesian product），又称直积，表示为 X × Y，是其第一个对象是 X 的成员而第二个对象是 Y 的一个成员的所有可能的有序对.

假设[集合](http://baike.baidu.com/view/15216.htm)A={a,b}，集合B={0,1,2}，则两个集合的笛卡尔积为{(a,0),(a,1),(a,2),(b,0),(b,1), (b,2)}。可以扩展到多个集合的情况。类似的例子有，如果A表示某学校学生的集合，B表示该学校所有课程的集合，则A与B的笛卡尔积表示所有可能的选课情况。



## 2.Join类型  

cross join 是笛卡儿乘积就是一张表的行数乘以另一张表的行数.
inner join 只返回两张表连接列的匹配项.
left join 第一张表的连接列在第二张表中没有匹配是,第二张表中的值返回null.
right join 第二张表的连接列在第一张表中没有匹配是,第一张表中的值返回null. 
full join 返回两张表中的行 left join+right join.

3.在对两表进行各种类型的join (cross, left, right, full, inner)时, 都需要构造笛卡尔积，中间的三个join都是笛卡尔积的子集

https://www.cnblogs.com/lihongda/p/9053678.html

https://blog.csdn.net/lx678111/article/details/82725548



### 3.join的底层原理，（主要是介绍left join）

https://cloud.tencent.com/developer/article/1502328