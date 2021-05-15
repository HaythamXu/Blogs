package algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithm.tree.BTNode;
import algorithm.tree.BuildTree;
import algorithm.tree.OperateTree;
import algorithm.tree.SearchTree;

public class TreeApplication {
    private static BTNode ROOT_FULL;
    private static BTNode ROOT_NOT_FULL;
    private static BTNode ROOT_WITH_NULL;

    @BeforeEach
    public void beforeEach() {
//        List<Integer> bstFullArray = List.of(0,1,2,3,4,5,6);
//        TreeApplication.ROOT_FULL = BuildTree.bfsBuildTree(bstFullArray);
//        List<Integer> bstNotFullArray = List.of(0,1,2,3,4,5);
//        TreeApplication.ROOT_NOT_FULL = BuildTree.bfsBuildTree(bstNotFullArray);
//        List<Integer> bstFullArrayWithNull = new ArrayList<>(){{add(0);add(1);add(2);add(3);add(4); add(null); add(6);}};
//        TreeApplication.ROOT_WITH_NULL = BuildTree.bfsBuildTree(bstFullArrayWithNull);
    }

    @Test
    public void t001BuildTree() {
        this.checkTree(TreeApplication.ROOT_FULL, List.of(0,1,2,3,4,5,6));
        this.checkTree(TreeApplication.ROOT_NOT_FULL, List.of(0,1,2,3,4,5));
        this.checkTree(TreeApplication.ROOT_WITH_NULL, List.of(0,1,2,3,4,6));
    }

    @Test
    public void t002BuildTreeWithSortedNotFullList() {
        List<Integer> firstDepthFirstSearchList = OperateTree.firstDepthFirstSearch(TreeApplication.ROOT_FULL, null);
        Assertions.assertEquals(firstDepthFirstSearchList, List.of(0,1,3,4,2,5,6));
    }

    @Test
    public void t003GetTreeMaxGeight() {
        Assertions.assertEquals(SearchTree.getTreeMaxHeight(TreeApplication.ROOT_FULL), 3);
    }

    @Test
    public void t004FindNodeByVal() {
        Assertions.assertEquals(SearchTree.findNode(TreeApplication.ROOT_FULL, 4).val, 4);
    }

    @Test
    public void t005GetNodeHeight() {
        Assertions.assertEquals(SearchTree.getNodeHeight(TreeApplication.ROOT_FULL, 2), 2);
    }

    @Test
    public void t006BuildTree() {
        List<Integer> integerList = new ArrayList<>() {{add(0);
                                                        add(null);add(2);
                                                        add(null);add(null);add(null);add(6);
                                                        add(null);add(null);add(null);add(null);add(null);add(null);add(null);add(14);}};
        BTNode root = BuildTree.bfsBuildTree(integerList);
        System.out.println(root.toString());
        System.out.println(OperateTree.bfsSearchWithoutNull(root, null).toString());
        System.out.println(OperateTree.bfsSearch(root, null).toString());
    }

    @Test
    public void t007BuildTree() {
        List<Integer> integerList = new ArrayList<>() {{add(0);
            add(1);add(2);
            add(null);add(null);add(5);add(6);
            add(null);add(null);add(null);add(null);add(11);add(null);add(13);add(14);}};
        BTNode root = BuildTree.bfsBuildTree(integerList);
        System.out.println(root.toString());
        System.out.println(OperateTree.bfsSearchWithoutNull(root, null).toString());
        System.out.println(OperateTree.bfsSearch(root, null).toString());
    }

    private void checkTree(BTNode actualTree, List<Integer> expectedTree) {
        Assertions.assertEquals(OperateTree.bfsSearchWithoutNull(actualTree, null), expectedTree);
    }
}
