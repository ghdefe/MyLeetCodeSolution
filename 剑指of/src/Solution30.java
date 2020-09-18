import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution30 {
    private Stack<Integer> stack, stack2;

    /**
     * initialize your data structure here.
     */
    public Solution30() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.pop().equals(stack2.peek())) {    //这里需要用equals，用==会变成比较地址，int太大时会使用缓存外的对象造成比较结果不相同
            stack2.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */


