Caused by: java.io.FileNotFoundException: \\.\pipe\controller_log_4992 (系统找不到指定的文件。)

解决方法：在Elasticsearch/config/elasticsearch.yml加入以下参数:

```yml

action.auto_create_index: .security,.monitoring*,.watches,.triggered_watches,.watcher-history*
xpack.security.enabled: false
xpack.monitoring.enabled: true
xpack.graph.enabled: false
xpack.watcher.enabled: false
xpack.ml.enabled: false
```

然后再次启动

原文地址：https://blog.csdn.net/u011781521/article/details/77139701