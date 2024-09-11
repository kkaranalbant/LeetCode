/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package longestcommentprefix1;

/**
 *
 * @author kaan
 */
public class LongestCommonPrefix1 {

    public static void main(String[] args) {

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
                if (!word.contains(substring)) {
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
