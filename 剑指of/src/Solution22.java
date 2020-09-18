/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第 k 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
class Solution22 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 0; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            node.next = listNode;
            node = node.next;
        }
        ListNode kthFromEnd = new Solution22().getKthFromEnd(head, 2);
    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low = head, fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

