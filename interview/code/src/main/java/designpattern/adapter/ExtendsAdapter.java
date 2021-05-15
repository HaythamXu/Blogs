package designpattern.adapter;

// 旧的类, 不允许修改的类
class Banner {
//    private String string;
    protected String string;
    public Banner(String string) { this.string = string; }
    public void showWithParen() { System.out.println("(" + string + ")"); }
    public void showWithAster() { System.out.println("*" + string + "*"); }
}

// 需要支持的需求或需要拓展的实现, 屏蔽就有的类实现
interface PrintAdapter {
    public abstract void printWeak();
    public abstract void printStrong();
}

// 对接口的具体实现, 变换器Adapter
class PrintAdapterImpl extends Banner implements PrintAdapter {
    public PrintAdapterImpl(String string) { super(string); }
    public void printWeak() { showWithParen(); }
    public void printStrong() { showWithAster(); }
}

class ClassAdapter extends Banner {
    public ClassAdapter(String string) { super(string); }
    public void printWeak() { showWithParen(); }
    public void printStrong() { showWithAster();}
}

class ClassAdapter2 extends Banner {
    public ClassAdapter2(String string) { super(string); }
//    @Override   // ？？重名与override？
    public void showWithParen() { System.out.println("(" + super.string + ")"); }
//    @Override
    public void showWithAster() { System.out.println("*" + super.string + "*"); }

}

// 关于为什么使用interface而不是直接extend.
// 首先extend无法继承父类private的属性，如果使用extend不得不修改父类的字短级别成protected.
// 其次继承将继承原有允许继承的方法，没有实现所谓的"屏蔽".
// 因此使用接口，后实现接口是最好的解决方案.
public class ExtendsAdapter {
    public static void main(String[] args) {
        PrintAdapter p = new PrintAdapterImpl("Hello");
        p.printWeak();
        p.printStrong();

        ClassAdapter mAdapter = new ClassAdapter("Hello");
        mAdapter.printStrong();
        mAdapter.showWithAster();
        mAdapter.printWeak();
        mAdapter.showWithParen();

        ClassAdapter2 mAdapter2 = new ClassAdapter2("Hello");
        mAdapter2.showWithAster();
        mAdapter2.showWithParen();
    }
}
