package mjdk.minterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MCloneable {

    /**
     * for basic data type
     */
    @Test
    public void basicType() {
        // 7
        int a = 1;
        int b = a;
        a = 2;
//        Assertions.assertEquals(2,a);
//        Assertions.assertEquals(1,b);
    }



}
