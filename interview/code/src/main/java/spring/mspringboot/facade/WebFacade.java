package spring.mspringboot.facade;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import spring.mspringboot.thread.SampleJob;
import spring.mspringboot.utils.ThreadCounter;

@Component
public class WebFacade {

    public void testAuthorization() {
//        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }

    public void testThread() {
        Thread t = new Thread(new SampleJob());
        t.start();
    }

    @Async
    public void testSync() {
        System.out.println("thread start");
        Map<String, String> map = new HashMap<>();
        for(int i=0; i<100; i++) {
            map.put("key"+i, "value"+i);
        }
        long startTime = System.currentTimeMillis();

        ThreadCounter counter1 = new ThreadCounter("counter 1",map.size(), 0);
        map.keySet().parallelStream().forEach(key -> {
            try {
                this.aJob(key, map.get(key));
                counter1.add(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("thread end");
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000 + "s");
    }

    private void aJob(String key, String value) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(String.format("%s-%s finished", key,value));
    }

}






