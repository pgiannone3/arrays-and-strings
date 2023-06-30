package two.sum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] arr = new int[] {1,2,3,4,5,6,7,8,9,10};
        s.twoSum1(arr, 9, 0, arr.length-1);

    }

    public int[] twoSum(int[] nums, int target) {

        var map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            var aNum = nums[i];
            Integer maybePresent = target - aNum;
            var ith = map.get(maybePresent);

            if(ith != null) {
                return new int[] {i, ith};
            }

            map.put(aNum, i);
        }
        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target, int start, int end) {
        if(start > end) {
            return new int[]{};
        }

        var first = nums[start];
        var last = nums[end];
        var sum = first + last;
        if (sum == target) {
            return new int[] {start, end};
        }


        if(sum > target) {
            return twoSum1(nums, target, start, end-1);
        } else {
            return twoSum1(nums, target, start+1, end);
        }
    }
}
