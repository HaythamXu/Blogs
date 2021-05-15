package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import algorithm.tree.BTNode;
import algorithm.tree.BuildTree;
import algorithm.tree.OperateTree;

public class LCTree {

    /**
     * leetcode offer0897
     * url: https://leetcode-cn.com/problems/increasing-order-search-tree/
     */
    @Test
    public void offer0042() {
        // ---------- given  [5,3,6,2,4,null,8,1,null,null,null,7,9]
        List<Integer> integerList = new ArrayList<>() {{
            add(5);
            add(3);add(6);
            add(2);add(4);add(null);add(8);
            add(1);add(null);add(null);add(null);add(null);add(null);add(7);add(9);}};

        BTNode root = BuildTree.bfsBuildTree(integerList);
        System.out.println(OperateTree.bfsSearchWithoutNull(root, null).toString());
        System.out.println(OperateTree.bfsSearch(root, null).toString());
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int expectedResult = 6;
        // ---------- solution
//        Assertions.assertEquals(expectedResult, this.solutionOffer0042_01(nums));
//        Assertions.assertEquals(expectedResult, this.solutionOffer0042_02(nums));
    }
}
