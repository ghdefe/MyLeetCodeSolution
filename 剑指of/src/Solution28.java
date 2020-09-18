/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * Copy to clipboardErrorCopied
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Copy to clipboardErrorCopied
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * Copy to clipboardErrorCopied
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 两个对称节点要比较本身值、左节点左树和右节点右树、左节点右树和右节点左树
 */

class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isRerverse(root.left,root.right);
    }

    public boolean isRerverse(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isRerverse(left.left,right.right) && isRerverse(left.right,right.left);
    }


    public static void main(String[] args) {
        int[] vals = {1, 0, 1, -4, -3};
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

