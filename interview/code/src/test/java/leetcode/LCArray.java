package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LCArray {

    /**
     * leetcode offer0042
     * url: https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
     */
    @Test
    public void offer0042() {
        // ---------- given
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int expectedResult = 6;
        // ---------- solution
        Assertions.assertEquals(expectedResult, this.solutionOffer0042_01(nums));
        Assertions.assertEquals(expectedResult, this.solutionOffer0042_02(nums));
    }

    /**
     * Enumeration: 每次循环，每次计算子数组
     * time complexity  : O(N^3)
     * space complexity : O(1)
     */
    private int solutionOffer0042_01(int[] nums) {
        int max = nums[0];
        for(int i = 0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                int tempSum = 0;
                for(int k=i; k<j; k++) {
                    tempSum += nums[k];
                }
                if(tempSum > max) max = tempSum;
            }
        }
        return max;
    }

    /**
     * Enumeration: 利用第内层循环计算内层数组和
     * time complexity  : O(N^2)
     * space complexity : O(1)
     */
    public int solutionOffer0042_02(int[] nums) {
       int max = nums[0];
       for(int i=0; i<nums.length; i++) {
           int tempSum = 0;
           for(int j=i; j<nums.length; j++) {
               tempSum += nums[j];
               if(tempSum > max) max = tempSum;
           }
       }
       return max;
    }

    /**
     * Divide and Conquer
     * time complexity  : O()
     * space complexity : O()
     */
    public int solutionOffer0042_03(int[] nums) {
        int result = 0;
        return result;
    }

    /**
     * Dynamic Programming
     * time complexity  : O()
     * space complexity : O()
     */
    public int solutionOffer0042_04(int[] nums) {

        int result = 0;
        return result;
    }
}