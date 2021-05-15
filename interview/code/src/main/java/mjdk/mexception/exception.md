
#### Exception的继承族谱
* Throwable
    * Error(一般无法处理)(Not Checked Exception)
        * OutOfMemoryError
        * NoClassDefFoundError
        * StackOverflowError
        * ......
    * Exception
        * RuntimeException(Not Checked Exception)
            * NullPointerException
            * IndexOutOfBoundsException
            * SecurityException
            * IllegalArgumentException
                * NumberFormatException
        * IOException (Checked Exception)
            * UnsupportedCharsetException
            * FileNotFoundException
            * SocketException
        * ParseException
        * GeneralSecurityException
        * SQLException
        * TimeoutException

--- 
以下仅讨论 xxxException(not RuntimeException) (Checked Exception)

* 异常具有细分的子类异常，捕获时应将子异常放与前面
* finally 总是会执行，即使在try中正确执行了return

#### 异常处理方式
* try...catch...捕获并处理
* throw 向上抛出


#### NullPointerException
* 定义变量时就进行初始化
* 使用Optional<T>
* 尽早定位NullPointerException
* 通过JVM参数增强定位`java -XX:+ShowCodeDetailsInExceptionMessages Main.java`

#### 断言Assertion 
* 断言仅适用于开发时
* 断言默认为关闭状态，需通过JVM参数开启`-enableassertions` or `-ea`
* 可以通过配置让断言仅对某个类或包起作用`-ea:com.sample.sample.sample.Main` `-ea:com.sample.sample...`

##### 日志
* 常见日志库
    * JDK: `java.util.logging.Logger` : 局限较多,很少使用
    * Apache: `org.apache.commons.logging.Log`, `org.apache.commons.logging.LogFactory`
        * common logging: 默认情况下，Commons Loggin自动搜索并使用Log4j（Log4j是另一个流行的日志系统），如果没有找到Log4j，再使用JDK Logging。
    * Slf4j: `org.slf4j.Logger`, `org.slf4j.LoggerFactory.getLogger`
        * 模块化, 支持对日志筛选，定义格式，定义输出(console, file, socket, jdbc)
    * LogBack: `ch.qos.logback`, 性能更好
        * [Logback](https://www.jianshu.com/p/b3dedb8fb61e)