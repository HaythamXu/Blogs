package spring.mspringboot.utils;

public class StaticThreadCounter {
    public static final Object lock = new Object();
    public static int count = 0;
}
