/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package longestcommonprefix;

/**
 *
 * @author kaan
 */

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


*/
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"Flower", "Flow", "Flight"}));
    }

    private static String longestCommonPrefix(String[] strs) {
        String wordWithMinimumLength = "this is a long length message";
        for (String word : strs) {
            if (wordWithMinimumLength.length() > word.length()) {
                wordWithMinimumLength = word;
            }
        }
        String prefix = "";
        for (int i = wordWithMinimumLength.length(); i >= 0; i--) {
            boolean containsAll = true;
            String substring = wordWithMinimumLength.substring(0, i);
            for (String word : strs) {
                if (!word.substring(0, substring.length()).equals(substring)) {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                prefix = substring;
                break;
            }
        }
        return prefix;
    }

}
