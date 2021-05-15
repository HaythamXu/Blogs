[TOC]
## 基础概念
#### Jar vs War
* JAR Java Archive
* War Java Web Applcation Archive
both of them are archive file, War can run directly while most of time, Jar only some class archive.

but, for Springboot, the Jar generate by Springboot is “fat Jar” which contain a embedded tomcat inside it, so it can also run directly while War need a outside Tomcat, so if you want to deply only one application, use Jar, if need more than one application, War would be better.

#### opensdk vs 

#### DIO IoC

#### 网络请求库
* com.squareup.okhttp
* javax.servlet(Filter, FilterChain, RequestDispatcher, http.HttpServletRequest)
* org.slf4j.LoggerFactory
* org.springframework.stereotype.Component;


* Okhttp3
* java.net
* HttpClient
* 

知识体系


## 计算机

#### 计算组的组成
* CPU(CPU)
* 内存
* 硬盘

#### 计算机的

#### 计算机，操作系统，JVM
计算机硬件执行二进制代码，计算机上之上首先运行的操作系统。
操作系统分类很多类, 包括主机系统: MacOs, Linux, Windows，非主机系统: Android等，
JVM所做的事向上支持Java的语法，向下将Java代码翻译成不同操作系统所识别的可执行代码，也就是JVM会不断更新以覆盖更多的操作系统，这一步由Java所属公司完成，对于Java开发者，这不需要关系系统一级平台




## ?
* 单体应用

#### 云计算的基本组成
* 存储: Volume
* 计算: 硬件配置 
* 网络: 网络配置

#### 系统的基本组成
* 角色与权限
* 资源
* 处理逻辑

#### 有状态应用 vs 无状态应用
两个来自相同发起者的请求在服务器端是否具备上下文关系

#### 单体应用 vs 分布式应用
* 单体应用: 整个服务端为一个应用(随着体量增加会带来复杂，性能等方面问题)
* 分布式应用: 单体应用可以从纵向(独立的业务流程)或横向(技术分层，中台?)进行拆分转为单体应用.




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



## Junit Test
## Junit
* org.junit.jupiter.api.*

## Mockito BDDMockito




@Mock
@MockBean
@SpyBean











## ??
* org.springframework.test.web.servlet.MockMvc; 的 MockMvc用于发起请求
* BDDMockito的打桩与mockito的打桩有什么区别



## MockMvc
* 用于以mock的形式发起Http网络请求

#### perform()

#### andDo()

#### andExpect()

#### andReturn() 

## MockMvcResultHandlers
* 用于实现某些操作，如在andDo()中打印日志

## MockMvcResultMatchers
* 提供例如json解析工具用于在andExpect()中对结果的数据进行比较

## MockMvcRequestBuilders
* 用于创建Http请求，提供get, post, put等方法


#### 常见用例
* 打桩
```java
// 当url含有参数且不希望区分时，可以使用ArgumentMatchers.contains().
BDDMockito
    .given(this.restTemplate.exchange(
        ArgumentMatchers.contains(this.scimUserApiUrl),
        ArgumentMatchers.eq(HttpMethod.PUT),
        ArgumentMatchers.any(HttpEntity.class),
        ArgumentMatchers.eq(SCIMUserDTO.class)))
    .willReturn(new ResponseEntity<>(new SCIMUserDTO(), HttpStatus.OK))
```

* 发起请求
```java
// get
final String getUrl = "https://api.com/";
this.mockMvc
    .perform(MockMvcRequestBuilders
        .get(this.getUrl))
    .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
    .andExpect(MockMvcResultMatchers.jsonPath("$[0].permission", IsEqual.equalTo(Boolean.TRUE)))
    .andExpect(MockMvcResultMatchers.jsonPath("$[1].permission", IsEqual.equalTo(Boolean.TRUE)));

// post put
final String postUrl = "https://api.com/";
final String payload = "{\"key\":\"value\"}";
this.mockMvc
    .perform(MockMvcRequestBuilders
        .post(this.postUrl)
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.payload)
        .with(SecurityMockMvcRequestPostProcessors.csrf()))
    .andDo(MockMvcResultHandlers.print())
    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
    .andExpect(MockMvcResultMatchers.jsonPath("$.role", IsEqual.equalTo("expected String")));
```

#### 简单的层级差异mapper
```java
@Configuration
public class ModelConfig {
    private final ModelMapper modelMapper;

    public ModelConfig(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public ModelMapper createModelMapper() {
        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.addUModelMapping();
        return this.modelMapper;
    }

    private void addUModelMapping() {
        final TypeMap<Model, DTO> modelMap = this.modelMapper
            .createTypeMap(Model.class, DTO.class);

        modelMap.addMapping(model -> model.getSubObject().getField(),
              DTO::setField);
        modelMap.addMappings(mapper -> mapper.using(aConverter())
            .map(Model::getObjectList, DTO::setStringList));
    }

    private Converter<Collection<Object>, Collection<String>> aConverter() {
        return ctx -> {
            if (ctx.getSource() != null) {
                final Collection<EnvironmentCode> modelList = ctx.getSource();
                final Collection<String> stringList = new ArrayList<>();
                modelList.forEach( envCodeModel -> {
                    stringList.add(envCodeModel.getCode());
                });
                return estringList;
            }
            return null;
        };
    }
}
```

#### 提取对象数组的元素







## 环境变量读取
System.getenv( ) 环境变量

通过System.getProperties() 获取系统属情
```java
System.getenv("githubtoken"));
System.getProperty( "user.dir" ));
```


## Properties读取
#### 字符类型
```
KEY_NAME=value

@Value("${KEY_NAME}")
private String VARABLE_NAME;
```
#### 数组
```
KEY_NAME=1,2,3,4,5,6

@Value"${KEY_NAME}"）
private String[] elementToSearch; 
```

## Pom.xml读取




>         System.out.println("java_vendor:"  + System.getProperty( "java.vendor" ));
        System.out.println("java_vendor_url:" + System.getProperty("java.vendor.url" ));
        System.out.println("java_home:"  + System.getProperty( "java.home" ));
        System.out.println("java_class_version:" + System.getProperty("java.class.version" ));
        System.out.println("java_class_path:" + System.getProperty("java.class.path" ));
        System.out.println("os_name:"  + System.getProperty( "os.name" ));
        System.out.println("os_arch:"  + System.getProperty( "os.arch" ));
        System.out.println("os_version:"  + System.getProperty( "os.version" ));
        System.out.println("user_name:"  + System.getProperty( "user.name" ));
        System.out.println("user_home:"  + System.getProperty( "user.home" ));
        System.out.println("user_dir:"  + System.getProperty( "user.dir" ));
        System.out.println("java_vm_specification_version:" + System.getProperty("java.vm.specification.version" ));
        System.out.println("java_vm_specification_vendor:" + System.getProperty("java.vm.specification.vendor" ));
        System.out.println("java_vm_specification_name:" + System.getProperty("java.vm.specification.name" ));
        System.out.println("java_vm_version:" + System.getProperty("java.vm.version" ));
        System.out.println("java_vm_vendor:" + System.getProperty("java.vm.vendor" ));
        System.out.println("java_vm_name:"  + System.getProperty( "java.vm.name" ));
        System.out.println("java_ext_dirs:" + System.getProperty("java.ext.dirs" ));
        System.out.println("file_separator:" + System.getProperty("file.separator" ));
        System.out.println("path_separator:" + System.getProperty("path.separator" ));
        System.out.println("line_separator:" + System.getProperty("line.separator" ));




* 一对多表的建立
* 一对多表在表在Java代码中的增删查改
* 



#### Light
* @Entity
* @Audited
* @Table(uniqueConstraints = {@UniqueConstraint(name = "userrolescope_uidx", columnNames = { "user_id", "scope", "role_id" }) })
* @ManyToOne
* @JoinColumn



? @JoinColumn与OneToMany的区别













PagingAndSortingRepository
CrudRepository
paSpecificationExecutor<Blog> 

* FindById 直接用不方便
* DTO内不应该出现id，不应该暴露在外，可以考虑使用定制的唯一code来代替
* 


#### javax.persistence

* @Entity: 用于将类注册为Model
* @Table: 用于配置表的信息






## 表与表的关系

#### 一对多
```java
Book.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Page> pages;

Page.java
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

```



keyword
* 

```java

```






## KeyPoint
* 需要在数据库内先创建好schemas
* 需要一个Repository Interface
* 需要一个Model
* 在properties中添加sql配置



```bash
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/blog?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

#hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
#spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })


## Annotation

#### @CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy
* 需要启动类加上@EnableJpaAuditing
* 实体类加上@EntityListeners(AuditingEntityListener.class)
> @CreatedDate、@LastModifiedDate即可生效
> @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
* 实现interface AuditorAware
> @CreatedBy、@LastModifiedBy生效
```Java
@Configuration
public class UserIDAuditorBean implements AuditorAware<Long> {
    @Override
    public Long getCurrentAuditor() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        if (ctx == null) {
            return null;
        }
        if (ctx.getAuthentication() == null) {
            return null;
        }
        if (ctx.getAuthentication().getPrincipal() == null) {
            return null;
        }
        Object principal = ctx.getAuthentication().getPrincipal();
        if (principal.getClass().isAssignableFrom(Long.class)) {
            return (Long) principal;
        } else {
            return null;
        }
    }
}
```

#### 





? 线程安全？
？ 锁

## 线程

#### 进程与线程
* 进程 1:n 线程
* 一个应用(如IDEA)由一个进程运行

#### 线程安全
* 定义
    * 概括来说: 存在资源竞争的线程就是不安全的, 不存在资源竞争的线程就是安全的.
    * 主线程工作线程都有各自的内存，当工作线程需要读取主内存数据，又需要写入主内存，就可能不安全.
* 如何确保线程安全: 锁(synchronized关键字)
* 自线程安全的类: Stack，HashTable，StringBuffer...
* 非线程安全的类: ArrayList, HashMap, StringBuilder...




> 参考资料
> [Java线程安全与常见的线程安全的类](https://blog.csdn.net/tiandao321/article/details/81300489)




## 从元素列表中提取某列
```java

```

* 使用 stream进行条件判断
```java
final Collection<AObject> objectCollection = new ArrayList<>();
// this list will have lots of elems
objectCollection.stream().anyMatch(elemObject -> elemObject.getField() == "targetValue");
objectCollection.stream().allmatch(elemObject -> elemObject.getField() == "targetValue");
objectCollection.stream().noneMatch(elemObject -> elemObject.getField() == "targetValue");
objectCollection.stream().filter(elemObject -> elemObject.getField() == "targetValue").count(); // return long
```




* [Lambda新特性（一）--ForEach不能修改外部变量](https://blog.csdn.net/qq_36588586/article/details/89961585)
* [关于foreach循环不能修改变量的值问题](https://blog.csdn.net/weixin_44308662/article/details/109018583?utm_medium=distribute.pc_feed_404.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_feed_404.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecas)

* Lambda的forEach，是拷贝性的，不能修改原始值？？？
* 递归函数，递归时函数内的变量是每次递归时重新生成的独立的，要获取递归的所有结果，需要使用外部的变量。





## Java IO
* [java Process类详解！](https://zhuanlan.zhihu.com/p/44957705)
* [java Runtime.exec方法详解！](https://zhuanlan.zhihu.com/p/33547017)

* [java执行系统命令](https://blog.csdn.net/qq_31075763/article/details/96601750?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromBaidu-1.control)
* [通过Java实现bash命令过程解析](https://www.jb51.cc/java/534855.html)
* [Java执行shell脚本并返回结果两种方法的完整代码](https://www.cnblogs.com/zdz8207/p/java-linux-shell.html)

## Runtime
* java.lang


## Process
* java.lang




## IO

BufferedReader()
InputStreamReader()


* [理解Java中字符流与字节流的区别](https://www.cnblogs.com/absfree/p/5415092.html)
* [Java 流(Stream)、文件(File)和IO](https://www.runoob.com/java/java-files-io.html)
* [java IO(File类、字节流与字符流、字节字符转换流)](https://cloud.tencent.com/developer/article/1453811#:~:text=%E5%AD%97%E8%8A%82%E6%B5%81%E4%B8%8E%E5%AD%97%E7%AC%A6%E6%B5%81,%E5%9C%A8Java.io%E5%8C%85%E4%B8%AD%E6%93%8D%E4%BD%9C%E6%96%87%E4%BB%B6%E5%86%85%E5%AE%B9%E7%9A%84%E4%B8%BB%E8%A6%81%E6%9C%89%E4%B8%A4%E5%A4%A7%E7%B1%BB%EF%BC%9A%E5%AD%97%E8%8A%82%E6%B5%81%E3%80%81%E5%AD%97%E7%AC%A6%E6%B5%81%E3%80%82%E4%B8%A4%E7%B1%BB%E9%83%BD%E5%88%86%E4%B8%BA%E8%BE%93%E5%85%A5%E5%92%8C%E8%BE%93%E5%87%BA%E6%93%8D%E4%BD%9C%E3%80%82%E5%9C%A8%E5%AD%97%E8%8A%82%E6%B5%81%E4%B8%AD%E8%BE%93%E5%87%BA%E6%95%B0%E6%8D%AE%E4%B8%BB%E8%A6%81%E6%98%AF%E4%BD%BF%E7%94%A8OutputStream%E5%AE%8C%E6%88%90%EF%BC%8C%E8%BE%93%E5%85%A5%E4%BD%BF%E7%94%A8%E7%9A%84%E6%98%AFInputStream%EF%BC%8C%E5%9C%A8%E5%AD%97%E7%AC%A6%E6%B5%81%E4%B8%AD%E8%BE%93%E5%87%BA%E4%B8%BB%E8%A6%81%E6%98%AF%E4%BD%BF%E7%94%A8Writer%E7%B1%BB%E5%AE%8C%E6%88%90%EF%BC%8C%E8%BE%93%E5%85%A5%E4%B8%BB%E8%A6%81%E6%98%AF%E4%BD%BF%E7%94%A8Reader%E7%B1%BB%E6%B5%81)






## Class Object
* == 与 eqals() 的区别
    * eqals() 是 Object对象提供的一个方法, 在创建的对象没有重写的情况下比较两个对象的地址，复写后比较复写的内容(如值)
    > 因为基础数据类型不是Object的子类，因此不能使用eqals()进行比较
    * == 使用于基础数据类型，比较值， 适用于对象时，比较地址

* 浅拷贝与深拷贝
    * 浅拷贝指直接拷贝对象的引用，对新对象的修改将影响原对象
    * 深拷贝指拷贝对象的所有值，对新对象的修改对原对象无影响





* 对象的复制 https://blog.csdn.net/tounaobun/article/details/8491392

#### 对象的复制
* 8种基础数据类型的复制
    * 基础数据类型的划分:
        * boolean
        * char, byte
        * short, int, float, double, long
    * 基础数据类型间的直接赋值是创造新的"个体", 互相间是不影响的
    ```java
    int a = 1;
    int b = a;
    a = 2; // b still is 1
    ```

* 对象的复制
    * Shallow Copy(浅复制): 复写Object提供的clone()方法
    ```java
    class Student implements Cloneable{
        private int number;

        @Override
        public Object clone() {
            Student stu = null;
            try{
                stu = (Student)super.clone();
            }catch(CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return stu;
        }
    }
    ```








## 数据类型
#### 数据类型分类
* 内置数据类型(基本数据类型)
    * 8种(3类)基础数据类型,
    * 布尔类: boolean
    * 字符类: byte, char
    * 数字累: short, int, long, float, double
* 引用数据类型
    * 类似指针
    * 在Java内大部分其他类型均为引用类型: String, List, Set...

## String
####  String vs StringBuffer vs StringBuilder
* String 是不可变的
* StringBuffer与StringBuilder是可变的
* StringBuffer是线程安全的

#### StringBuffer
```java
stringBuffer.append(VALUE);
stringBuffer.deleteCharAt(TARGET_INDEX);
```
> [String、StringBuffer和StringBuilder的区别](https://blog.csdn.net/csxypr/article/details/92378336)

## 集合对象
#### 列表(List) 
* 批量初始化
```java
// Arrays -> dpn't support null
List jdks = asList("JDK6", "JDK8", "JDK10");
// anonymous
List names = new ArrayList<>() {{ add("Tom"); add("Sally");}};
// Steam
List colors = Stream.of("blue", "red", "yellow").collect(toList());
// List -> null will get error
List cups = List.of("A", "B", "C"); // JDK9, 
```

#### 数组(Array) vs 列表(ArrayList)
ArrayList -> ... -> List -> Collection -> Iterable

* 比较:
    * Array: 效率高，容量固定
    * ArrayList: 效率低, 容量动态.
    * 本质上ArrayList内是通过Array实现的，因此增加与插入操作开销较大.
* Array
    * 初始化: 
        * String[] strArray = new String[10];
        * String[] strArray = {"a", "b", "c"};
        * String[] strArray = new String[]{"a", "b", "c"};
    * 调用: strArray[0];
    * 修改: strArray[0] = "b";
    * 转化ArrayList: ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(strArray));
    * 转化ArrayList: Arrays.asList(strArray)
* ArrayList
    * 初始化: 
        * String[] List<String> list=new ArrayList<String>();
    * 调用: 
    * 修改: 
    * 转化Array: (String[])list.toArray(new String[list.size()])

> [Java中数组(Array)和列表(ArrayList)的区别](https://blog.csdn.net/sofuzi/article/details/79903981)
> [java中 列表，集合，数组之间的转换](https://blog.csdn.net/Jay112011/article/details/79999186)

? 接口实体化
? 使用子类实体化父类， 使用实体类实体化借口

#### Interable vs Interator(迭代器)
* Interable封装了Interator

> [Java-Iterable&Iterator](https://www.jianshu.com/p/0c916535aa02)





package: java.util


* java.util.Data

* [java集合Collection常用方法详解, 衍生](https://blog.csdn.net/javaee_gao/article/details/96372530)
* 

* Collection 于 Interator?是大部分Java提供的数据结构的父类
* Collection本身提供进行交际，并集，差集等集合操作.


#### 数组, 列表, 集合

HashMap -> ... -> Map
HashSet -> Set -> Collection -> Iterable


* StringUtil

#### 字符串截取
* String[]  strs=str.split(",");

#### 字符串切片
* sb.substring(startIndex) 截取startIndex到结尾
* sb.substring(startIndex, endIndex) 截取startIndex～endIndex的字符串
```java
String str = "1234567890";
str.substring(2);   // "34567890"
str.substring(3,5); // "345"
```


