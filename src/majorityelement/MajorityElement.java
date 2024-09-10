/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package majorityelement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author kaan
 */

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 

Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109

 */
public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int [] {1,2,2,2,2,2,3,1,3,4}));
    }

    private static int majorityElement(int[] nums) {
        Map<Integer, Integer> numRepeatMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (numRepeatMap.containsKey(nums[i])) {
                numRepeatMap.put(nums[i], numRepeatMap.get(nums[i]) + 1);
            } else {
                numRepeatMap.put(nums[i], 1);
            }
        }
        int max = Integer.MIN_VALUE;
        List<Integer> repeats = numRepeatMap.values().stream().collect(Collectors.toList());

        for (int i = 0; i < repeats.size(); i++) {
            if (repeats.get(i) > max) {
                max = repeats.get(i);
            }
        }
        int major = 0;
        for (Map.Entry<Integer, Integer> entry : numRepeatMap.entrySet()) {
            if (entry.getValue() == max) {
                major = entry.getKey();
                break;
            }
        }
        return major;
    }

}
