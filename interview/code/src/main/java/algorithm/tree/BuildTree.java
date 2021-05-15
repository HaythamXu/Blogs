package algorithm.tree;

import java.util.List;

public class BuildTree {

    /**
     * 根据广度优先遍历结果构建 "完全二叉树"
     * [0,1,2,3,4,5,6] ->
     *        0
     *    1      2
     *  3   4  5   6
     */
    public static BTNode bfsBuildTree(List<Integer> bstArray) {
        if(bstArray.contains(null)) {
            return BuildTree.bfsBuildTreeWithNull(bstArray, 0, bstArray.size());
        }
        return BuildTree.bfsBuildTreeWithoutNull(bstArray, 0, bstArray.size());
    }

    // 根据广度优先遍历结果构建 "完全二叉树", 不支持 null
    private static BTNode bfsBuildTreeWithoutNull(List<Integer> bstArray, int index, int length) {
        if(index >= length || bstArray.get(index) == null) return null;
        BTNode node = new BTNode(bstArray.get(index));
        node.left = bfsBuildTreeWithoutNull(bstArray, index*2 + 1, length);
        node.right = bfsBuildTreeWithoutNull(bstArray, index*2 + 2, length);
        return node;
    }

    // 根据广度优先遍历结果构建 "完全二叉树", 支持 null
    private static BTNode bfsBuildTreeWithNull(List<Integer> bstArray, int index, int length) {
        if(index >= length) return null;
        else {
            Integer currentValue = bstArray.get(index);
            if(currentValue != null) {
                BTNode node = new BTNode(currentValue);
                int leftIndex = 2*index + 1;
                int rightIndex = 2*index + 2;
                if(leftIndex >= length) {
                    // left index out of stack
                    return node;
                } else {
                    // left index exist
                    Integer leftValue = bstArray.get(leftIndex);
                    if(rightIndex >= length) {
                        // right out of stack
                        if(leftValue == null) return node;
                        else {
                            node.left = bfsBuildTreeWithNull(bstArray, leftIndex, length);
                            return node;
                        }
                    } else {
                        // right exist
                        Integer rightValue = bstArray.get(rightIndex);
                        if(leftValue == null && rightValue == null) return node;
                        else if(leftValue != null && rightValue == null) {
                            node.left = bfsBuildTreeWithNull(bstArray, leftIndex, length);
                            return node;
                        }
                        else if(leftValue == null && rightValue != null) {
                            node.right = bfsBuildTreeWithNull(bstArray, rightIndex, length);
                            return node;
                        }
                        else  {
                            node.left = bfsBuildTreeWithNull(bstArray, leftIndex, length);
                            node.right = bfsBuildTreeWithNull(bstArray, rightIndex, length);
                            return node;
                        }
                    }
                }
            } else {
                return null;
            }
        }
    }

}
