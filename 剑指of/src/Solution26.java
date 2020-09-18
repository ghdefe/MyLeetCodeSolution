import java.util.ArrayList;
import java.util.Iterator;

/**
 * 看答案了
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        return isSub(A, B) || isSubStructure(A.right,B) || isSubStructure(A.left,B);
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        return isSub(A.left,B.left) && isSub(A.right,B.right);
    }

    public static void main(String[] args) {
        int[] vals = {1,0,1,-4,-3};
        TreeNode[] treeNodes = new TreeNode[vals.length];
        for (int i = 0; i < vals.length; i++) {
            treeNodes[i] = (new TreeNode(vals[i]));
        }
        TreeNode head = treeNodes[0];
        treeNodes[0].left = treeNodes[1];
        treeNodes[0].right = treeNodes[2];
        treeNodes[1].left = treeNodes[3];
        treeNodes[1].right = treeNodes[4];

        TreeNode subNode1 = new TreeNode(1);
        TreeNode subNode2 = new TreeNode(-4);
        subNode1.left = subNode2;

        boolean subStructure = new Solution26().isSubStructure(head, subNode1);
        System.out.println(subStructure);

    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

