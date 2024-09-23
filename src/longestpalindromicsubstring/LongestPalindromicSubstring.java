/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package longestpalindromicsubstring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author kaan
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        PriorityQueue <String> queue1 = getSubstrings("cbbd");
        String longestPalindromicSubstring = "" ;
        while(!queue1.isEmpty()) {
            String substring = queue1.poll() ;
            if (isPalindromic(substring)) {
                longestPalindromicSubstring = substring ;
                break ;
            }
        }
        System.out.println(longestPalindromicSubstring);
    }

//    private static String longestPalindrome(String s) {
//        
//    }

    private static boolean isPalindromic(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true ;
    }
    
    private static PriorityQueue<String> getSubstrings (String s) {
        Comparator<String> comparator = (s1 , s2) -> Integer.compare(s2.length(), s1.length()) ;
        PriorityQueue<String> substrings = new PriorityQueue(comparator) ;
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i ; j <= s.length() ; j++) {
                String substring = s.substring(i,j);
                substrings.add(substring);
            }
        }
        return substrings ;
    }

}
