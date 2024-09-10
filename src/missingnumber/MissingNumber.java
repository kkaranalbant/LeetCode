/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package missingnumber;

import java.util.Arrays;

/**
 *
 * @author kaan
 */

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

 */
public class MissingNumber {

    public static void main(String[] args) {

        int missingOne = findMissing(new int[]{3, 0, 1});
        int missingTwo = findMissing(new int[]{0,1});
        int missingThree = findMissing(new int[]{9,6,4,2,3,5,7,0,1});
        
        System.out.println(missingOne+"\n"+missingTwo+"\n"+missingThree);

    }

    private static int findMissing(int[] nums) {
        Arrays.sort(nums);
        int value = 0;
        int n = nums.length;
        boolean found = false;
        for (int i = 0; i < n - 1 && !found; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                value = i + 1;
                found = true;
            }
        }
        if (!found) {
            if (nums[0] != 0) {
                value = 0;
            } else {
                value = n;
            }
        }
        return value;
    }

}
