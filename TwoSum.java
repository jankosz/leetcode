import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * https://leetcode.com/problems/two-sum
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberWithIndice = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numberWithIndice.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int searchedNumber = target - number;

            if (numberWithIndice.containsKey(searchedNumber)) {
                int secondIndice = numberWithIndice.get(searchedNumber);
                if ( i != secondIndice) {
                    int[] indices = new int[]{i, secondIndice};
                    return indices;
                }
            }

        }
        return null;
    }
}
