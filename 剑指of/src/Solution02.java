import java.util.HashSet;

class Solution02 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num))
                return num;
        }
        return -1;
    }
}
