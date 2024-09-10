/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ispalindrome;

/**
 *
 * @author kaan
 */

/*
Given an integer x, return true if x is a
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 

Constraints:

    -2^31 <= x <= 2^31 - 1

 */
public class IsPalindrome {

    public static void main(String[] args) {
        boolean testOne = isPalindrome(121);
        boolean testTwo = isPalindrome(-121);
        boolean testThree = isPalindrome(10);
        System.out.println(testOne + "\n" + testTwo + "\n" + testThree);
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || x == Integer.MAX_VALUE) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int digit = 0;
        int copyNumber = x;
        while (copyNumber != 0) {
            copyNumber /= 10;
            digit++;
        }
        copyNumber = x;
        int reverseNumber = 0;
        int counter = 1;
        while (copyNumber != 0) {
            reverseNumber += (copyNumber % 10) * Math.pow(10, digit - counter);
            copyNumber /= 10;
            counter++;
        }
        return reverseNumber == x;
    }

}
