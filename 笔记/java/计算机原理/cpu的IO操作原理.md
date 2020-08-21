https://blog.csdn.net/qwe6112071/article/details/71822185

https://www.jianshu.com/p/2399c65e4b8b

https://blog.csdn.net/SlowIsFastLemon/article/details/103271743



==========

IO原理

https://www.jianshu.com/p/85f3cad79c33

1、 物理 I/O 通常是从磁盘等存储设备实际获取数据。逻辑 I/O 是对存储器（块，缓冲区）获取数据。 

2、 I/O 软件的最后一个问题是缓冲(buffering)。通常情况下，从一个设备发出的数据不会直接到达最后的设备。其间会经过一系列的校验、检查、缓冲等操作才能到达。 

3、DMA 的中文名称是直接内存访问，它意味着 CPU 授予 I/O 模块权限在不涉及 CPU 的情况下读取或写入内存。也就是 DMA 可以不需要 CPU 的参与。这个过程又称为 DMA 控制器（DMAC）的芯片管理。由于 DMA 设备可以直接在内存之间传输数据，而不是使用 CPU 作为中介，因此可以缓解总线上的拥塞。DMA 通过允许 CPU 执行任务，同时 DMA 系统通过系统和内存总线传输数据来提高系统并发性。