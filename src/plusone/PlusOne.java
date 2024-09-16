/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plusone;

/**
 *
 * @author kaan
 */

/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

 

Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.


 */
public class PlusOne {

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{8, 9, 9, 9, 9});
        for (int digit : result) {
            System.out.println(digit);
        }
    }

    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        int firstAdjacentNineIndex = findFirstAdjacentNineIndex(digits);
        int[] result = null;
        if (firstAdjacentNineIndex == -1) {
            digits[n - 1] += 1;
            result = digits;
        } else if (firstAdjacentNineIndex == 0) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; i++) {
                newDigits[i] = 0;
            }
            result = newDigits;
        } else {
            digits[firstAdjacentNineIndex - 1] += 1;
            for (int i = firstAdjacentNineIndex; i < n; i++) {
                digits[i] = 0;
            }
            result = digits;
        }
        return result;
    }

    private static int findFirstAdjacentNineIndex(int[] digits) {
        int result = -1;
        if (digits[digits.length - 1] != 9) {
            return result;
        }
        boolean found = false;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 9 && !found) {
                result = i;
                found = true;
            }
            if (digits[i] != 9) {
                found = false;
            }
        }
        return result;
    }

}
