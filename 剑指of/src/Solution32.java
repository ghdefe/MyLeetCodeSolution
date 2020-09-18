import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int count = 1;      //当前遍历总共要遍历几个
        int cen = 1;        //当前是第几层
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int num = 0;    //记录当前遍历层有几个节点
            while (count > 0) {
                TreeNode now = queue.poll();
                temp.add(now.val);
                if (now.left != null) {
                    queue.add(now.left);
                    num++;
                }
                if (now.right != null) {
                    queue.add(now.right);
                    num++;
                }
                count--;
            }
            if (cen % 2 == 0) {
                Collections.reverse(temp);
            }
            res.add(temp);
            count = num;
            cen++;
        }

        return res;

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


