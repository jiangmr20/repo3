报错：has been injected into other beans

原因是各个bean间循环依赖，可使用@Lazy

当然最好还是解耦

https://blog.csdn.net/heboy19/article/details/79373832

https://blog.csdn.net/Jas000/article/details/78106804

