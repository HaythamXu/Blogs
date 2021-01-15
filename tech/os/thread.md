## 多核CPU与多CPU
* 计算机的5大基本组成：运算器，控制器，存储器，输入，输出
* 针对某个CPU的某个核：运算器+控制器+寄存器(L1/L2/L3某种存储器)+总线(I/O)
* 多CPU: 多个CPU通过I/O链接
* 多核CPU: 多个CPU通过底层缓存(L2 or L3)链接
* CPU->核心->


> L1/L2/L3 > 内存 > 硬盘
> [reference](https://www.cnblogs.com/valjeanshaw/p/11469514.html)


## 线程与进程
* 现在大多数设备为多核设备，为多核系统
* “对于任何Python程序，不管有多少的处理器，任何时候都总是只有一个线程在执行”
* python “假的多线程”

#### 编译型语言与解释型语言
* 编译型语言： C

* 解释型语言： python, Java?