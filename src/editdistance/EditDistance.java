/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editdistance;

/**
 *
 * @author kaan
 */
public class EditDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }

    private static int minDistance(String word1, String word2) {
        int addingCounter = 0;
        int removingCounter = 0;
        StringBuilder word1CommonSb = new StringBuilder () ;
        StringBuilder word2CommonSb = new StringBuilder () ;
        for (char character : word2.toCharArray()) {
            if (!word1.contains(String.valueOf(character))) {
                addingCounter++;
            }
            else {
                word1CommonSb.append(character);
            }
        }
        for (char characher : word1.toCharArray()) {
            if (!word2.contains(String.valueOf(characher))) {
                removingCounter++ ;
            }
            else {
                word2CommonSb.append(characher);
            }
        }
        String word1Common = word1CommonSb.toString() ;
        String word2Common = word2CommonSb.toString() ;
        System.out.println(word1Common);
        System.out.println(word2Common);
        int swapCounter = 0 ;
        for (int i = 0 ; i < word1Common.length() ; i++) {
            if (word2Common.indexOf(word1Common.charAt(i)) != i) {
                swapCounter++ ;
            }
        }
        if (swapCounter != 0) {
            swapCounter-- ;
        }
        return swapCounter + addingCounter + removingCounter ;
    }

}
