package spring.mspringboot.utils;

public class ThreadCounter {
    private String id;
    private int total = 0;
    private int counter = 0;

    public ThreadCounter(String id, int total, int counter) {
        this.id = id;
        this.total = total;
        this.counter = counter;
    }

    public synchronized void add(int n) {
        this.counter += n;
        System.out.println(this.id + " : " + this.counter + "/" + this.total);
    }

    public int get() {
        return this.counter;
    }

    public String getId() {
        return this.id;
    }
}


