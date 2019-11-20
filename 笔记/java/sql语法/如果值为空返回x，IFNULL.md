例子：

```sql
select product_id id ,product_name productName,IFNULL(keyword,"-")
        keyWord,IFNULL(developUnit,"-") operateUnit,product_type
        productType,product_level productLevelId, process_id processId,IFNULL(online_time,"-") onlineTime, status
        from tb_province_product
```

