package leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LCBitManipulation {

    /**
     * leetcode: 1720
     * url: https://leetcode-cn.com/problems/decode-xored-array/
     */
    @Test
    public void solution1720() {
        // ------ given ------
        int[] encoded = {6,2,7,3};
        int first = 4;
        int[] expected = {4,2,0,7,4};
        /// ------ solution ------
        Assertions.assertTrue(Arrays.equals(expected, this.solution1720(encoded, first)));
    }

    private int[] solution1720(int[] encoded, int first) {
        int[] r = new int[encoded.length+1];
        r[0] = first;
        for(int i =1;i<r.length;i++){
            r[i] = (encoded[i-1]^r[i-1]);
        }
        return r;
    }
}
