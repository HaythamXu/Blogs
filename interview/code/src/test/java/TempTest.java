import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mjdk.mexception.MLogging;

public class TempTest {

    private static Logger LOGGER = LoggerFactory.getLogger(TempTest.class);

    @Test
    public void temp001() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(null);
        integerList.add(3);
        integerList.add(null);
        integerList.add(5);
        TempTest.LOGGER.info(integerList.toString());
        TempTest.LOGGER.info("{}",integerList.contains(null));
    }
}
