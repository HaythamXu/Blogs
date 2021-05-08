package spring.springbootweb.controller;

import org.springframework.stereotype.Component;

@Component
public class WebFacade {

    public void testThread() {
        System.out.println("test thread");
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("thread end.");
    }
}