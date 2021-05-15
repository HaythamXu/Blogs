package spring.mspringboot.thread;

public class SampleJob implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("thread end.");
    }
}