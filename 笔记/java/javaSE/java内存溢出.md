即使java有垃圾回收机制自动清除无用内存，但其清除标识用的是GC root去寻找对象的可达状态，在实际中仍可能会存在可达但是无用的内存，如在while(true)内无限生成对象，依然会导致内存泄露。

https://blog.csdn.net/weixin_41860630/article/details/86762824

https://blog.csdn.net/sinat_34089391/article/details/80558956

