/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package findfirstandlastpositionofelementinsortedarray;

/**
 *
 * @author kaan
 */

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109


*/
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int [] nums = new int [] {5,7,7,8,8,10} ;
        for (int index : searchRange(nums, 8)) {
            System.out.println(index);
        }
    }

    private static int[] searchRange(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        int[] result = new int[]{-1, -1};
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == target) {
                result[0] = mid;
                break;
            } else if (nums[mid] < target) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        if (result[0] != -1) {
            for (int i = result[0]; i < nums.length; i++) {
                if (nums[i] == target) {
                    result[1] = i;
                }
            }
            for (int i = result[0]; i >= 0; i--) {
                if (nums[i] == target) {
                    result[0] = i;
                }
            }
        }
        return result;
    }

}
