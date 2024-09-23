/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reverseinteger;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kaan
 */

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 

Constraints:

    -231 <= x <= 231 - 1


 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(120));

    }

    private static int reverseInteger(int x) {
        if (x == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
        while (x != 0) {
            sb.append(Integer.toString(x % 10));
            x /= 10;
        }
        int result = 0;
        if (sb.length() < 10) {
            result = Integer.parseInt(sb.toString());
        } else if (sb.length() == 10) {
            byte[] maxValueDigits;
            if (isNegative) {
                maxValueDigits = new byte[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8};
            } else {
                maxValueDigits = new byte[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
            }
            Map<Integer, String> indexStateMap = new HashMap();
            int minFalseIndex = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
                int difference = maxValueDigits[i] - ((byte) sb.charAt(i) - '0');
                if (difference < 0) {
                    indexStateMap.put(i, "FALSE");
                    minFalseIndex = Math.min(minFalseIndex, i);
                } else if (difference > 0) {
                    indexStateMap.put(i, "TRUE");
                } else {
                    indexStateMap.put(i, "EQUAL");
                }
            }
            boolean found = false;
            for (int i = 0; i < minFalseIndex && !found; i++) {
                if (indexStateMap.get(i).equals("TRUE")) {
                    found = true;
                }
            }
            if (found) {
                result = Integer.parseInt(sb.toString());
            }

        }

        if (isNegative) {
            result *= -1;
        }
        return result;
    }
}
