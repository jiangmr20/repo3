left join：左链接，LEFT JOIN 关键字会从左表 (table_name1) 那里返回所有的行，即使在右表 (table_name2) 中没有匹配的行。而INNER JOIN则不会返回没有匹配的行。

所以，当使用小表链接大表的时候，使用INNER JOIN会链接大表所有数据导致返回太多数据，特别是百万级的表，笛卡尔积特别大。所有就应该使用left join，因为该关键字从左表的行做链接，只返回左表的行链接到的，所以返回小表的数据，数据量不会大

https://blog.csdn.net/jh_zhai/article/details/80215092

一个特别问题：下面两个查询的结果集有什么不同么？

```sql
SELECT * FROM product LEFT JOIN product_details
         ON (product.id = product_details.id)
         AND   product_details.id=2;
SELECT * FROM product LEFT JOIN product_details
         ON (product.id = product_details.id)
         WHERE product_details.id=2;
```

