package mjdk.moop;

// getClass() : [Ljava.lang.String;@4554617c    “[” 表示一维数组    "[["表示二维数组  "L"表示一个对象
class ConstructorAndMethod {
    private String string;
    // 对于没有初始化的字短，基础数据类型为会初始化为默认值，对于引用类型初始化为null.
    private String string2;
    // 当创造自定义构造方法时，默认无参数构造方法将失效.
    public ConstructorAndMethod() { this("default"); }
    public ConstructorAndMethod(String string) { this.string = string; }
    // 参数的值传递存在三种情况: 基础数据类型(), 内容不可变引用类型, 内容可变引用类型.
    // 对于内容不可变引用类型， 如String, 改变值相当于改变新的地址，因此传递是安全的.
    // 对于内容可变引用类型， 如数组, 由于数组改变值时地址没有变化，因此外部改变内容，类内部也会变化，这种情况需要特殊处理.
    public void MMethod1(String... strings) {}
    // Method: 当参数为数组时，需要检查是否为null, 否则容易导致NPE.
    public void MMethod2(String[] strings) {}
}

class Person {
    private String name;
    private int age;
    public Person(String name, int age) { this.name = name; this.age = age; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

class Student extends Person {
    // 父类的private字段与方法时无法被子类访问的,如果想让子类访问, 需要使用protected.
    // 对于不想被继承的字段或方法, 使用final.
    private int score;
    //private String name;   // 编译器允许出现与父类相同变量名的方法，但是不推荐这么做.
    // 编译器会自动在子类初始化时调用父类的构造器，空则调用默认构造器super()(但若父类没有默认构造器则会报错)
    public Student(String name, int age, int score) { super(name, age); this.score = score; }
    public int getScore() { return this.score; }
    public void setScore(int score) { this.score = score; }
}
// 继承是is关系，组合是has关系。



public class MClass {
    public static void main(String[] argv) {
        MClass.testMethodDefine();
        MClass.testExtendAndCasting();
    }

    private static void teat() {

    }

    private static void testExtendAndCasting() {
        Student student = new Student("name", 18, 100);
        MClass.print(student.getName());

        Person person = new Student("name", 18, 100);
        MClass.print(person.getAge());
        // person.getScore() // upcasting向上转型并不允许调用子类的属性和方法.
        MClass.print(person instanceof Person);     // true
        MClass.print(person instanceof Student);    // true
        // 向下转型downcasting时, 转换不妙instanceof要相同, 父类使用子类构造器实现的可以转化为子类, 否则不会.
        // Student student1 = new Person("name", 18);
    }

    private static void testMethodDefine() {
        ConstructorAndMethod constructorAndMethod = new ConstructorAndMethod("hi");
        constructorAndMethod.MMethod1(new String[] {"str1","str2","str1",});
        constructorAndMethod.MMethod1(null);
        constructorAndMethod.MMethod2(null);
    }

    private static void print(Object o) {
        System.out.println(o.toString());
    }
}
