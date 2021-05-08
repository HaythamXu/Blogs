package mjdk;

import java.lang.Thread;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class MTime {

    @Test
    public void calculateTimeGap() throws Exception {
        long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        TimeUnit.SECONDS.sleep(1);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)/1000 + "s");
    }
}
